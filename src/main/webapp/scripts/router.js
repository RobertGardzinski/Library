var app = angular.module("myRouteApp", [ "ngRoute" ]);
		app.config(function($routeProvider) {
			$routeProvider.when("/", {
				template : "This is main site. Nothing to do here."
			}).when("/listPage", {
				templateUrl : "templates/listPage.html"
			}).when("/newRecord", {
				templateUrl : "templates/newRecord.html"
			});
		});