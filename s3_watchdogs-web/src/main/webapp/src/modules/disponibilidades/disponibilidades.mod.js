(function (ng) {
    
    var mod = ng.module("disponibilidadModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/disponibilidades/';
            
            $urlRouterProvider.otherwise("/disponibilidadesList");
            
            $stateProvider.state('disponibilidadesList', {
                
                url: '/disponibilidades/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'disponibilidad.display.html',
                        controller: 'disponibilidadCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);


