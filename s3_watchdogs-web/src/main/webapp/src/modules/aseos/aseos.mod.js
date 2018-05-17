/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("aseosModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.constant("aseosContext", "api/aseos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/aseos/';
            $urlRouterProvider.otherwise("/aseoDetail");
            
            $stateProvider.state('aseoDetail', {
                url: '/aseos/{aseoId:int}/detail',
                param: {
                    aseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'aseos.view.html',
                        controller: 'aseoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('aseoTerminado', {
                url: '/aseos/{aseoId:int}/terminado',
                //parent: 'entrenamientoDetail',
                param: {
                    aseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'aseos.terminado.html',
                        controller: 'aseoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('aseosCreate', {
               
                //parent: 'entrenamientoDetail',
                param:{
                    clienteId: null
                },
                url: '/clientes/{clienteId:int}/aseos/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/aseos.new.html',
                        controller: 'aseoNewCtrl'
                    }
                }
                }).state('aseoDelete', {
                url: '/aseos/{aseoId:int}/delete',
                //parent: 'entrenamientoDetail',
                param: {
                    aseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/delete/aseos.delete.html',
                        controller: 'aseoDeleteCtrl'
                    }
                }
                }).state('aseoUpdate', {
                url: '/clientes/{clienteId:int}/aseos/{aseoId:int}/update',
                //parent: 'entrenamientoDetail',
                param: {
                    aseoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/aseos.new.html',
                        controller: 'aseoUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);
