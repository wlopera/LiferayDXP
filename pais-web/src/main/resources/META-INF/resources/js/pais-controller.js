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

     var xhr = paisService.getPaises();

      xhr.then(function(response) {        
        console.log(response);
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

     var xhr = paisService.getPaisByName(name);

      xhr.then(function(response) {        
        console.log(response);
        vm.pais = response.data;
        vm.pais= "";
      });

      xhr.catch(function(exception) {
        $log.error('error getPaises: '+exception);
      });

      xhr.finally(function() {
        $log.log("Fin getPais");
      });

    };

    // Llena los campos de pais seleccionado 
    vm.seleccionarPais = function(item) {
    	vm.pais= item;
    }
    
    // Agregar pais a la lista
    vm.agregarPais = function() {
    	console.log("##=> Agregar Pais: ", vm.pais);
    	 var xhr = paisService.agregarPais(vm.pais);
    	 
         xhr.then(function(response) {        
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error getPaises: '+exception);
         });

         xhr.finally(function() {
           $log.log("Fin getPais");
         });
    }
    // Modificar pais seleccionado 
    vm.modificarPais = function() {
    	console.log("##=> Modificar Pais: ", vm.pais);
    	var xhr = paisService.modificarPais(vm.pais);
    	 
         xhr.then(function(response) {        
           console.log(response);
         });

         xhr.catch(function(exception) {
           $log.error('error getPaises: '+exception);
         });

         xhr.finally(function() {
           $log.log("Fin getPais");
         });
    }
    // limpiar los campos de pais selecionado 
    vm.limpiarCampos = function() {
    	console.log("##=> Limpiar campos Pais");
    	vm.pais= "";
    }
    
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
