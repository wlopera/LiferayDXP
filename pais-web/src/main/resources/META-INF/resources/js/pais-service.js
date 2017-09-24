(function(win) {
  "use strict";

  var WS_PATH = "/o/api/pais";

  var paisService = function($log, serviceInvoker) {

    $log.info("Consumiendo servicio paisService");

    // Consultar de Paises
    function getPaises() {
      return serviceInvoker.invoke("GET", WS_PATH + "/getPaises");
    }

    // Agregar Pais
    function agregarPais(pais) {
        return serviceInvoker.invoke("POST", WS_PATH + "/agregarPais", pais);
    }

    // Modificar Pais
    function modificarPais(pais) {
        return serviceInvoker.invoke("POST", WS_PATH + "/modificarPais", pais);
    }

    return {
    	getPaises: getPaises,
    	agregarPais: agregarPais,
    	modificarPais: modificarPais
    };

  };

  paisService.$inject = ["$log", "serviceInvoker"];

  win.MainApp.Services.service("paisService", paisService);

}(window));