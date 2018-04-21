(function (ng) {

    var mod = ng.module("empleadosAdminModule", ['ui.router']);
    mod.constant("empleadosAdminContext", "api/empleados");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/empleados/admin/';
            //var basePathMascotas = "src/modules/mascotas/";

            $urlRouterProvider.otherwise("/empleadosAdminList");

            $stateProvider.state('empleadosAdmin', {
                url: '/empleados/admin/',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'empleadosAdmin.html',
                        controller: 'empleadosAdminCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'empleadosAdmin.nav.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: ['admin', 'assistant']
                }
            }).state('empleadosAdminList', {
                url: '/list',
                parent: 'empleadosAdmin',
                views: {
                    'listView': {
                        templateUrl: basePath + 'empleadosAdmin.list.html'
                    }
                }
            }).state('empleadoAdminDetail', {
                url: '/{empleadoId:int}/detail',
                parent: 'empleadosAdmin',
                param: {
                    empleadoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'empleadosAdmin.detail.html',
                        controller: 'empleadoAdminDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('empleadosAdminCreate', {
                url: '/create',
                parent: 'empleadosAdmin',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/empleadosAdmin.new.html',
                        controller: 'empleadoAdminNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('empleadoAdminUpdate', {
                url: '/update/{empleadoId:int}',
                parent: 'empleadosAdmin',
                param: {
                    empleadoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/empleadosAdmin.new.html',
                        controller: 'empleadoAdminUpdateCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('empleadoAdminDelete', {
                url: '/delete/{empleadoId:int}',
                parent: 'empleadosAdmin',
                param: {
                    empleadoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/empleadosAdmin.delete.html',
                        controller: 'empleadoAdminDeleteCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            });
        }]);
})(window.angular);