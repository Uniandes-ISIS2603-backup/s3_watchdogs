/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.constant("hotelesContext", "api/hoteles");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/hoteles/';
            $urlRouterProvider.otherwise("/hotelDetail");
            
            $stateProvider.state('hotelDetail', {
                url: '/hoteles/{hotelId:int}/detail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'hoteles.view.html',
                        controller: 'hotelDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('hotelTerminado', {
                url: '/hoteles/{hotelId:int}/terminado',
                //parent: 'entrenamientoDetail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'hoteles.terminado.html',
                        controller: 'hotelDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('hotelesCreate', {
                url: '/clientes/{clienteId:int}/hoteles/create',
                //parent: 'hotelDetail',
                param:{
                    clienteId:null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/hoteles.new.html',
                        controller: 'hotelNewCtrl'
                    }
                }
                }).state('hotelDelete', {
                url: '/hoteles/{hotelId:int}/delete',
                //parent: 'hotelDetail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/delete/hoteles.delete.html',
                        controller: 'hotelDeleteCtrl'
                    }
                }
                }).state('hotelUpdate', {
                url: '/hoteles/{hotelId:int}/update',
                //parent: 'entrenamientoDetail',
                param: {
                    hotelId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/hoteles.new.html',
                        controller: 'hotelUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);