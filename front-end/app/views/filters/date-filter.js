'use strict';
(function() {
    	angular.module('app.filters', []).filter('dateFormater', function($filter){
            return function (date) {
                var dateResult = new Date(date);
                console.log(dateResult);
                var result = '';
                result+= dateResult.getDate() + '/' + (dateResult.getMonth()+1)+ '/' + dateResult.getFullYear();
                return result;
            }
        }) ;
    
})();