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

    /*
     ==============
     METHODS
     ==============
    */

    vm.getPaises = function() {

      $log.info("Inicio getPaises");

      var xhr = paisService.getPaises();

      xhr.then(function(response) {        
        console.log(response);
        $log.info(response.data);
        vm.paises = response.data;
      });

      xhr.catch(function(exception) {
        log.error('error getPaises: '+exception);
      });

      xhr.finally(function() {
        $log.log("Fin getPaises");
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
