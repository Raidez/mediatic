'use strict';
(function() {
    	angular.module('app.filters', []).filter('dateFormater', function($filter){
            return function (date) {
                return moment(date).format('DD/MM/YYYY');
            }
            
            
            
        }).filter('afterToday', function($filter) {
            return function (table, field) {
               if(table===undefined) {
                   return table;
               } else {
                   return table.filter(function(item){
                       return moment(item[field]).isAfter(moment(),'day');
                   });
               }
            }
            
            
            
        }).filter('beforeToday', function($filter) {
            return function (table, field) {
               if(table===undefined) {
                   return table;
               } else {
                   return table.filter(function(item){
                       return moment(item[field]).isSameOrBefore(moment(),'day');
                   });
               }
            }
            
            
            
        }) ;
    
})();