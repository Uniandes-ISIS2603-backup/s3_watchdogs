(function (ng) {
    
    var mod = ng.module("clienteModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = "src/modules/cliente/";
            
            $urlRouterProvider.otherwise("/clienteList");
            
            $stateProvider.state('clienteList', {
                url: 'cliente/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'cliente.list.html',
                        controller: 'clienteCtrl',
                        controllerAr: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);