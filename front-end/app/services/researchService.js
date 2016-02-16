'use strict';
(function() {
    angular.module('app.researchService', []).
    provider('adherentService',{
        $get: function($http,$q,adherentService) {
            //var provider=this;
            var inProgress = false;
            return {
                currentResearch:{
                    currentPage:undefined,
                    maxPage:undefined,
                    params:undefined
                },
                doResearch: function(params) {
                    return adherentService.getTaille.then(function(response){
                        this.currentResearch.currentPage=0;
                        this.currentResearch.maxPage=response.data.pages;
                        this.currentResearch.params=params;
                        return adherentService.getAdherents(this.currentResearch.currentPage,this.currentResearch.params);
                    });
                    
                },
                next: function () {
                    var defer = $q.defer();
                    if(!inProgress){
                        inProgress = true;
                        var nextPage = this.currentResearch.currentPage+1;
                        if(nextPage < this.currentResearch.maxPage) {
                            adherentService.getAdherents(nextPage,this.currentResearch.params).then(function(data){
                                this.currentResearch.currentPage=nextPage;
                                inProgress = false;
                                defer.resolve(data);
                            });
                        } else {
                            defer.reject();
                        }
                    } else {
                        defer.reject(2);
                    }
                    return defer.promise;
                }
            };
        }
    });
})();