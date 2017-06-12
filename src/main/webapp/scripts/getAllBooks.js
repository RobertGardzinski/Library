var app = angular.module("myRouteApp");
app.controller('getAllBooksController', function($scope, $http, $log) {
		    $http.get('/getAllBooks').
		        then(function(response) {
		            $scope.bookList = response.data; 
		        });
		});