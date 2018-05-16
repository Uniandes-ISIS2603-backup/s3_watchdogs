(function (ng) {

    var mod = ng.module("clientesModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/clientes/';
            //var basePathMascotas = "src/modules/mascotas/";

            $urlRouterProvider.otherwise("/clientesList");

            $stateProvider.state('clientes', {
                url: '/clientes',
                //abstract: true,
                views: {
                    'completeView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'clientes.nav.html'
                    }
                }
            }).state('clientesList', {
                url: '/list',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'clienteDetailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clientesCreate', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clientesNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clienteUpdate', {
                url: '/{clienteId:int}/update',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'clienteUpdateView': {
                        templateUrl: basePath + '/update/clientes.update.html',
                        controller: 'clienteUpdateCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('clienteDelete', {
                url: '/delete/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('clienteServiciosList', {

                parent: 'clienteDetail',

                views: {
                    serviciosClienteList: {
                        templateUrl: basePath + 'clientesServicios.list.html',
                        controller: 'clienteServiciosCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('clienteMascotasList', {

                parent: 'clienteDetail',

                views: {
                    mascotasClienteList: {
                        templateUrl: basePath + 'clientesMascotas.list.html',
                        controller: 'clienteMascotasCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('mascotaCreate', {

                url: 'mascota/create',
                parent: 'clienteDetail',

                views: {
                    create: {
                        templateUrl: basePath + 'clientesMascotas.create.html',
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('temporalMascotaCreate', {
                params: {
                    name: null,
                    color: null,
                    raza: null,
                    imagen: null,
                    sexo: null
                },
                url: 'mascota/create',
                parent: 'clienteDetail',

                views: {
                    create: {
                        controller: 'clienteMascotasCreateCtrl',
                        templateUrl: basePath + 'clientesMascotas.create.html',

                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            })
                    ;
        }]);
})(window.angular);