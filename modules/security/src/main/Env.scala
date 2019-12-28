package oyun.security

import akka.actor._
import com.softwaremill.macwire._
import play.api.Configuration
import play.api.libs.ws.WSClient

import oyun.common.config._
import oyun.user.{ UserRepo }

final class Env(
  appConfig: Configuration,
  ws: WSClient,
  net: NetConfig,
  userRepo: UserRepo
)(implicit ec: scala.concurrent.ExecutionContext, system: ActorSystem) {


  lazy val store = new Store()

  lazy val api = wire[SecurityApi]
  
}
