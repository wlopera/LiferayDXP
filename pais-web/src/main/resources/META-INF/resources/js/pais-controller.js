(function(win) {
  "use strict";

  var PaisController = function($log, $window, paisService) {

    $log.info("Consumir Controller PaisController");

    /*
     ==============
     VALUES
     ==============
   */

    // VM
    var vm = this;

    vm.paises = {};
    vm.pais = '';

    /*
     ==============
     METHODS
     ==============
    */

    // Consultar lista de paises
    vm.getPaises = function() {

      $log.info("Inicio getPaises");

      var xhr = paisService.getPaises();

      xhr.then(function(response) {        
        console.log(response);
        $log.info("##=> Paises: "+ response.data);
        vm.paises = response.data;
      });

      xhr.catch(function(exception) {
        $log.error('error getPaises: '+exception);
      });

      xhr.finally(function() {
        $log.log("Fin getPaises");
      });

    };
    
    // Consultar pais por nombre
    vm.getPaisByName = function(name) {

      $log.info("Inicio getPais: " , name);

      var xhr = paisService.getPaisByName(name);

      xhr.then(function(response) {        
        console.log(response);
        $log.info("##=> Pais: "+ response.data);
        vm.pais = response.data;
      });

      xhr.catch(function(exception) {
        $log.error('error getPaises: '+exception);
      });

      xhr.finally(function() {
        $log.log("Fin getPais");
      });

    };

    /*
     ==============
     SETUP
     ==============
    */
    vm.setup = function() {

    };

    vm.setup();
  };

  /*
   ==============
   CONFIGURATION
   ==============
  */
  PaisController.$inject = [
    "$log",
    "$window",
    "paisService"
  ];

  win.MainApp.Controllers
    .controller("PaisController",
      PaisController);

}(window));
