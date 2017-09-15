(function(win) {
  "use strict";

  var WS_PATH = "/o/api/pais";

  var paisService = function($log, serviceInvoker) {

    $log.info("Consumiendo servicio paisService");

    function getPaises() {
      return serviceInvoker.invoke("GET", WS_PATH + "/getPaises");
    }

    return {
    	getPaises: getPaises
    };

  };

  paisService.$inject = ["$log", "serviceInvoker"];

  win.MainApp.Services.service("paisService", paisService);

}(window));