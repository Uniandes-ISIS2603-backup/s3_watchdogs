(function (ng) {
    var mod = ng.module("mascotaModule", ['ui.router']);
    mod.constant("mascotasContext", "api/mascotas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/mascotas/';
            $urlRouterProvider.otherwise("/mascotasList");
            $stateProvider.state('mascotas', {
                url: '/mascotas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'mascotas.html',
                        controller: 'mascotaCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLoin: false,
                    roles: []
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
                        templateUrl: basePath + 'mascotas.list.html',
                        controller: 'mascotaDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'mascotas.detail.html',
                        controller: 'mascotaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);