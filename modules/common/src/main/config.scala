package oyun.common

import io.methvin.play.autoconfig._
import play.api.ConfigLoader

object config {

  case class BaseUrl(value: String) extends AnyVal

  case class NetDomain(value: String) extends AnyVal
  case class AssetDomain(value: String) extends AnyVal

  case class NetConfig(
    domain: NetDomain,
    protocol: String,
    @ConfigName("base_url") baseUrl: BaseUrl,
    @ConfigName("asset.domain") assetDomain: AssetDomain,
    @ConfigName("socket.domain") socketDomain: String,
    crawlable: Boolean
  )

  implicit val baseUrlLoader = strLoader(BaseUrl.apply)
  implicit val netDomainLoader = strLoader(NetDomain.apply)
  implicit val assetDomainLoader = strLoader(AssetDomain.apply)
  implicit val netLoader = AutoConfig.loader[NetConfig]


  def strLoader[A](f: String => A): ConfigLoader[A] = ConfigLoader(_.getString) map f
}
