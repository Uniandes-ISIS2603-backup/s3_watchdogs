(function (ng) {
    
    var mod = ng.module("facturaModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/facturas/';
            
            $urlRouterProvider.otherwise("/facturasList");
            
            $stateProvider.state('facturasList', {
                
                url: '/facturas/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'facturas.list.html',
                        controller: 'facturaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);