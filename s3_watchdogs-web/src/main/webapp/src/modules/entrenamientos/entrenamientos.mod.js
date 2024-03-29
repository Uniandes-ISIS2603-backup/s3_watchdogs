/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientosModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/entrenamientos/';
            $urlRouterProvider.otherwise("/entrenamientoDetail");
            
            $stateProvider.state('entrenamientoDetail', {
                url: '/entrenamientos/{entrenamientoId:int}/detail',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'entrenamientos.view.html',
                        controller: 'entrenamientoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('entrenamientoTerminado', {
                url: '/entrenamientos/{entrenamientoId:int}/terminado',
                //parent: 'entrenamientoDetail',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'entrenamientos.terminado.html',
                        controller: 'entrenamientoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('entrenamientosCreate', {
                url: '/clientes/{clienteId:int}/entrenamientos/create',
                //parent: 'entrenamientoDetail',
                param:{
                    clienteId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/entrenamientos.new.html',
                        controller: 'entrenamientoNewCtrl'
                    }
                }
                }).state('entrenamientoDelete', {
                url: '/entrenamientos/{entrenamientoId:int}/delete',
                //parent: 'entrenamientoDetail',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/delete/entrenamientos.delete.html',
                        controller: 'entrenamientoDeleteCtrl'
                    }
                }
                }).state('entrenamientoUpdate', {
                url: '/clientes/{clienteId:int}/entrenamientos/{entrenamientoId:int}/update',
                //parent: 'entrenamientoDetail',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/entrenamientos.new.html',
                        controller: 'entrenamientoUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);
