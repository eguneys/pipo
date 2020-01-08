export function make(send, ctrl) {

  function reload(o, isRetry) {
    
  }

  const d = ctrl.data;

  const handlers = {
  };

  return {
    send,
    handlers,
    sendLoading(typ, data) {
      ctrl.setLoading(true);
      send(typ, data);
    },
    receive(typ, data) {
      if (handlers[typ]) {
        handlers[typ](data);
        return true;
      }
      return false;
    },
    reload
  };

}
