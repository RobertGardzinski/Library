var app = angular.module("myRouteApp");
app.controller('orderBy', function($scope) {
	$scope.orderByMe = function(x) {
		$scope.myOrderBy = x;
	}
});