 (function (ng) {
    
    var mod = ng.module("instalacionesAdminModule", ['ui.router']);
    mod.constant("instalacionesAdminContext", "api/instalaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/instalaciones/admin/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/instalacionesAdminList");
            
            $stateProvider.state('instalacionesAdmin', {
                url: '/instalacionesAdmin',
                views: {
                    'completeView': {
                        templateUrl: basePath + 'instalacionesAdmin.html',
                        controller: 'instalacionesAdminCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'instalacionesAdmin.nav.html'
                    }
                }
            }).state('instalacionesAdminList', {
                url: '/list',
                parent: 'instalacionesAdmin',
                views: {
                    'listView': {
                        templateUrl: basePath + 'instalacionesAdmin.list.html'
                    }
                }
            }).state('instalacionAdminDetail', {
                url: '/{instalacionAdminId:int}/detail',
                parent: 'instalacionesAdmin',
                param: {
                  instalacionId: null  
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'instalacionesAdmin.detail.html',
                        controller: 'instalacionAdminDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('instalacionesAdminCreate', {
                url: '/createAdmin',
                parent: 'instalacionesAdmin',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/instalacionesAdmin.new.html',
                        controller: 'instalacionAdminNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('instalacionAdminUpdate', {
                url: '/update/{instalacionAdminId:int}',
                parent: 'instalacionesAdmin',
                param: {
                    instalacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/instalacionesAdmin.new.html',
                        controller: 'instalacionAdminUpdateCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('instalacionAdminDelete', {
                url: '/delete/{instalacionAdminId:int}',
                parent: 'instalacionesAdmin',
                param: {
                    instalacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/instalacionesAdmin.delete.html',
                        controller: 'instalacionAdminDeleteCtrl'
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