 (function (ng) {
    
    var mod = ng.module("mascotasModule", ['ui.router']);
    mod.constant("mascotasContext", "api/mascotas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/mascotas/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/mascotasList");
            
            $stateProvider.state('mascotas', {
                url: '/mascotas',
                //abstract: true,
                views: {
                    'completeView': {
                        templateUrl: basePath + 'mascotas.html',
                        controller: 'mascotasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'mascotas.nav.html'
                    }
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
                    'mascotaDetailView': {
                        templateUrl: basePath + 'mascotas.detail.html',
                        controller: 'mascotaDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'mascotas.list.html'
                    }
                }
            }).state('mascotasCreate', {
                url: '/create',
                parent: 'mascotas',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/mascotas.new.html',
                        controller: 'mascotasNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('mascotaUpdate', {
                url: '/{mascotaId:int}/update',
                parent: 'mascotas',
                param: {
                    clienteId: null
                },
                views: {
                    'mascotaUpdateView': {
                        templateUrl: basePath + '/update/mascotas.update.html',
                        controller: 'mascotaUpdateCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'mascotas.list.html'
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