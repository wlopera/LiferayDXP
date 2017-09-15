  var app = angular.module('myApp', []);
  app.controller('myCtrl', function($scope) {
	  console.log("2222");
      $scope.firstName = "John";
      $scope.lastName = "Doe";
  });