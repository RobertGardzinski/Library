var app = angular.module("myRouteApp");
app.controller('formSubmitController',[ '$scope', '$http', '$location', function($scope, $http, $location) {		
			$scope.submit = function() {
				
				var formData = {
						"author" : $scope.author,
						"title" : $scope.title,
						"isbn" : $scope.isbn	
				};
				
				var response = $http.post('addBook', formData);
				response.success(function(data, status, headers, config) {
					$scope.author = "";
					$scope.title = "";
					$scope.isbn = "";
					$location.path('/listPage');
					$location.replace();
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
				
			};
		}]);