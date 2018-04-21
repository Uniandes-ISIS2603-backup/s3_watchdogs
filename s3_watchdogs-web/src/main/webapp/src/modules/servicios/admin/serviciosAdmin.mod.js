 (function (ng) {
    
    var mod = ng.module("serviciosAdminModule", ['ui.router']);
    mod.constant("serviciosAdminContext", "api/servicios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/servicios/admin/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/serviciosAdminList");
            
            $stateProvider.state('serviciosAdmin', {
                url: '/servicios/admin',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'serviciosAdmin.html',
                        controller: 'serviciosAdminCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'serviciosAdmin.nav.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: ['admin', 'assistant']
                }
            }).state('serviciosAdminList', {
                url: '/list',
                parent: 'serviciosAdmin',
                views: {
                    'listView': {
                        templateUrl: basePath + 'serviciosAdmin.list.html'
                    }
                }
            }).state('servicioAdminDetail', {
                url: '/{servicioId:int}/detail',
                parent: 'serviciosAdmin',
                param: {
                  servicioId: null  
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'serviciosAdmin.detail.html',
                        controller: 'servicioAdminDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('serviciosAdminCreate', {
                url: '/create',
                parent: 'serviciosAdmin',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/serviciosAdmin.new.html',
                        controller: 'servicioAdminNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('servicioAdminUpdate', {
                url: '/update/{servicioId:int}',
                parent: 'serviciosAdmin',
                param: {
                    servicioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/serviciosAdmin.new.html',
                        controller: 'servicioAdminUpdateCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('servicioAdminDelete', {
                url: '/delete/{servicioId:int}',
                parent: 'serviciosAdmin',
                param: {
                    servicioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/serviciosAdmin.delete.html',
                        controller: 'servicioAdminDeleteCtrl'
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