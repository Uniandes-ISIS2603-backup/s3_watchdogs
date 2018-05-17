(function (ng) {
    
    var mod = ng.module("rutaModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/rutas/';
            
            $urlRouterProvider.otherwise("/rutasList");
            
            $stateProvider.state('rutas', {
                
                url: '/rutas/list',
                 views: {
                     'completeView': {
                        templateUrl: basePath + 'rutas.html',
                        controller: 'rutasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'rutas.nav.html'
                    }
                }
            }).state('rutasList', {
                url: '/list',
                parent: 'rutas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'rutas.list.html'
                    }
                }
            });
        }
    ]);
})(window.angular);
