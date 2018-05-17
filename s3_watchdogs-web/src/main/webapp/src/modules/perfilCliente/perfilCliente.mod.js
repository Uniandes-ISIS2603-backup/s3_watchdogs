(function (ng) {
    
    var mod = ng.module("perfilModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/perfilCliente/';
            
            $urlRouterProvider.otherwise("/perfilCliente");
            
            $stateProvider.state('miPerfil', {
                params: {
                    clienteId: null
                },
                url: '/miPerfil',
               
                views: {
                    'navView': {
                        templateUrl: basePath + 'perfilCliente.nav.html'
                    },
                    'completeView': {
                        templateUrl: basePath + 'cliente.profile.html',
                        controller: 'perfilCtrl'
                    }
                }
            });
    }]);
})(window.angular);

