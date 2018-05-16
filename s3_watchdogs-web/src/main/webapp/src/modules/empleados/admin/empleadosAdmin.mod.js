 (function (ng) {
    
    var mod = ng.module("empleadosAdminModule", ['ui.router']);
    mod.constant("empleadosAdminContext", "api/empleados");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/empleados/admin/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/empleadosAdminList");
            
            $stateProvider.state('empleadosAdmin', {
                url: '/empleados/admin',
                //abstract: true,
                views: {
                    'completeView': {
                        templateUrl: basePath + 'empleadosAdmin.html',
                        controller: 'empleadosAdminCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'empleadosAdmin.nav.html'
                    }
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
                  mascotaId: null  
                },
                views: {
                    'empleadoAdminDetailView': {
                        templateUrl: basePath + 'empleadosAdmin.detail.html',
                        controller: 'empleadoAdminDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'empleadosAdmin.list.html'
                    }
                }
            }).state('empleadosAdminCreate', {
                url: '/create',
                parent: 'empleadosAdmin',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/empleadosAdmin.new.html',
                        controller: 'empleadosAdminNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('empleadoAdminUpdate', {
                url: '/{empleadoId:int}/update',
                parent: 'empleadosAdmin',
                param: {
                    empleadoId: null
                },
                views: {
                    'empleadoAdminUpdateView': {
                        templateUrl: basePath + '/update/empleadosAdmin.update.html',
                        controller: 'empleadosAdminUpdateCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'empleadosAdmin.list.html'
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
                    mascotaId: null
                },
                views: {
                    'empleadoAdminDetailView': {
                        templateUrl: basePath + '/delete/empleadosAdmin.delete.html',
                        controller: 'empleadoAdminDeleteCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('serviciosClienteList', {
                url: '/servicios',
                parent: 'empleadoAdminDetail',
                views: {
                    empleadoAdminServicioListView: {
                        templateUrl: basePath + 'empleadosAdmin.servicios.list.html',
                        controller: 'empleadoAdminServiciosListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            ;
    }]);
})(window.angular);