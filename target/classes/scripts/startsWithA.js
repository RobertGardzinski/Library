var app = angular.module("myRouteApp");
app.directive('startsWithA', function() {
		    return {
		        require: 'ngModel',
		        link: function(scope, element, attr, mCtrl) {
		            function myValidation(value) {
		            	var res = value.split(" ");
		                for (i = 0; i < res.length; i++) { 
		                    if ( res[i][0] == 'A' ) {
		                        mCtrl.$setValidity('charA', true);
		                        break;
		                    } else {
		                        mCtrl.$setValidity('charA', false);
		                    }
		                }
		                return value;
		            }
		            mCtrl.$parsers.push(myValidation);
		        }
		    };
		});