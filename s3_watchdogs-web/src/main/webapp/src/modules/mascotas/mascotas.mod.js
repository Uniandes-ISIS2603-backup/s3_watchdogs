(function (ng) {
    
    var mod = ng.module("mascotasModule", ['ui.router']);
    mod.constant("mascotasContext", "api/mascotas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/mascotas/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/mascotasList");
            
            $stateProvider.state('mascotas', {
                url: '/mascotas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'mascotas.html',
                        controller: 'mascotasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'mascotas.nav.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: ['admin', 'assistant']
                }
            }).state('mascotasList', {
                url: '/list',
                parent: 'mascotas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'mascotas.list.html'
                    }
                }
            }).state('mascotaDetail', {
                url: '/{mascotaId:int}/detail',
                parent: 'mascotas',
                param: {
                  mascotaId: null  
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'mascotas.detail.html',
                        controller: 'mascotaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('mascotasCreate', {
                url: '/create',
                parent: 'mascotas',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/mascotas.new.html',
                        controller: 'mascotaNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('mascotaUpdate', {
                url: '/update/{mascotaId:int}',
                parent: 'mascotas',
                param: {
                    mascotaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/mascotas.new.html',
                        controller: 'mascotaUpdateCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('mascotaDelete', {
                url: '/delete/{mascotaId:int}',
                parent: 'mascotas',
                param: {
                    mascotaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/mascotas.delete.html',
                        controller: 'mascotaDeleteCtrl'
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