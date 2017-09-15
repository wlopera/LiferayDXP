(function(win) {
  "use strict";

  var TestController = function($log, $window, testService, alertNotifyService) {

    $log.debug("[Liferay/Angular/TestController] Initializing...");

    /*
     ==============
     VALUES
     ==============
   */

    // VM
    var vm = this;

    vm.name = "";

    /*
     ==============
     METHODS
     ==============
    */

    vm.sayHello = function() {

      $log.debug("Inicio Hello");

      var xhr = testService.sayHello(vm.name);

      xhr.then(function(response) {
        alertNotifyService.showSuccess(response.data.greeting);
      });

      xhr.catch(function(exception) {
        alertNotifyService.showError('error');
      });

      xhr.finally(function() {
        $log.debug("Fin Hello");
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
  TestController.$inject = [
    "$log",
    "$window",
    "testService",
    "alertNotifyService"
  ];

  win.MainApp.Controllers
    .controller("TestController",
      TestController);

}(window));
