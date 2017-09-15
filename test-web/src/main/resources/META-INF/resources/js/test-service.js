(function(win) {
  "use strict";

  var WS_PATH = "/o/api/test";

  var testService = function($log, serviceInvoker) {

    $log.debug(
      "[Liferay/Angular/TestService] Initializing..."
    );

    function sayHello(name) {
      return serviceInvoker.invoke("GET", WS_PATH + "/hello/" + name);
    }

    return {
      sayHello: sayHello
    };

  };

  testService.$inject = ["$log", "serviceInvoker"];

  win.MainApp.Services.service("testService", testService);

}(window));