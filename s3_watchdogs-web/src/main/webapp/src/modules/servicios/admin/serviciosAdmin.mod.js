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
                    'completeView': {
                        templateUrl: basePath + 'serviciosAdmin.html',
                        controller: 'serviciosAdminCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'serviciosAdmin.nav.html'
                    }
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
                    'servicioDetailView': {
                        templateUrl: basePath + 'serviciosAdmin.detail.html',
                        controller: 'servicioAdminDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'serviciosAdmin.list.html'
                    }
                }
            }).state('serviciosAdminCreate', {
                url: '/create',
                parent: 'serviciosAdmin',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/serviciosAdmin.new.html',
                        controller: 'servicioAdminNewCtrl'
                    }
                }
            }).state('servicioAdminUpdate', {
                url: '/update/{servicioId:int}',
                parent: 'serviciosAdmin',
                param: {
                    servicioId: null
                },
                views: {
                    'servicioUpdateView': {
                        templateUrl: basePath + '/new/serviciosAdmin.new.html',
                        controller: 'servicioAdminUpdateCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'serviciosAdmin.list.html'
                    }
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