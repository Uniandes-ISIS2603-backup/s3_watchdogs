/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule", ['ui.router']);
    mod.constant("paseosContext", "api/paseos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/paseos/';
            $urlRouterProvider.otherwise("/paseoDetail");
            
            $stateProvider.state('paseoDetail', {
                url: '/paseos/{paseoId:int}/detail',
                param: {
                    paseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'paseos.view.html',
                        controller: 'paseoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('paseosCreate', {
                url: '/paseos/create',
                //parent: 'paseoDetail',
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/paseos.new.html',
                        controller: 'paseoNewCtrl'
                    }
                }
                }).state('paseoDelete', {
                url: '/paseos/{paseoId:int}/delete',
                //parent: 'paseoDetail',
                param: {
                    paseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/delete/paseos.delete.html',
                        controller: 'paseoDeleteCtrl'
                    }
                }
                }).state('paseoUpdate', {
                url: '/paseos/{paseoId:int}/update',
                //parent: 'paseoDetail',
                param: {
                    paseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/paseos.new.html',
                        controller: 'paseoUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);
