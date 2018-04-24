(function (ng) {
    
    var mod = ng.module("rutaModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/rutas/';
            
            $urlRouterProvider.otherwise("/rutasList");
            
            $stateProvider.state('rutasList', {
                
                url: '/rutas/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'rutas.list.html',
                        controller: 'rutaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);
