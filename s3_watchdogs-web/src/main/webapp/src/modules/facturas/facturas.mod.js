 (function (ng) {
    
    var mod = ng.module("facturasModule", ['ui.router']);
    mod.constant("facturasContext", "api/facturas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/facturas/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/facturas");
            
            $stateProvider.state('facturas', {
                url: '/facturas',
                //abstract: true,
                views: {
                    'completeView': {
                        templateUrl: basePath + 'facturas.html',
                        controller: 'facturasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'facturas.nav.html'
                    }
                }
            }).state('facturasList', {
                url: '/list',
                parent: 'facturas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'facturas.list.html'
                    }
                }
            });
    }]);
})(window.angular);