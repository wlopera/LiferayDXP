(function(win) {
  "use strict";

  var WS_PATH = "/o/api/pais";

  var paisService = function($log, serviceInvoker) {

    $log.info("Consumiendo servicio paisService");

    // Consultar de Paises
    function getPaises() {
      return serviceInvoker.invoke("GET", WS_PATH + "/getPaises");
    }

    // Consultar paispor nombre
    function getPaisByName(name) {
        return serviceInvoker.invoke("POST", WS_PATH + "/getPaisByName", name);
      }
    
    return {
    	getPaises: getPaises,
    	getPaisByName: getPaisByName
    };

  };

  paisService.$inject = ["$log", "serviceInvoker"];

  win.MainApp.Services.service("paisService", paisService);

}(window));