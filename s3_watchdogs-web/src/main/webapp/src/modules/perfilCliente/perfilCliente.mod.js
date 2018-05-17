(function (ng) {
    
    var mod = ng.module("perfilModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/perfilCliente/';
            
            $urlRouterProvider.otherwise("/perfilCliente");
            
            $stateProvider.state('miPerfil', {
                params: {
                    clienteId: null,
                    rol: null
                },
                url: '/miPerfil',
               
                views: {
                    'navView': {
                        templateUrl: basePath + 'perfilCliente.nav.html'
                    },
                    'completeView': {
                        templateUrl: basePath + 'cliente.profile.html',
                        controller: 'perfilCtrl'
                    }
                }
            }).state('clientePerfilMascotasList', {

                parent: 'miPerfil',

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
            }).state('mascotaPerfilCreate', {

                url: 'mascota/create',
                parent: 'miPerfil',

                views: {
                    create: {
                        templateUrl: basePath + 'clientesMascotas.create.html'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('temporalMascotaPerfilCreate', {
                params: {
                    name: null,
                    color: null,
                    raza: null,
                    imagen: null,
                    sexo: null
                },
                url: 'mascota/create',
                parent: 'miPerfil',

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

