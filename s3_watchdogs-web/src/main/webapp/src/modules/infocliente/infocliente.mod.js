(function (ng) {
    
    var mod = ng.module("infoclienteModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/infocliente/';
            
            $urlRouterProvider.otherwise("/infoclienteList");
            
            $stateProvider.state('infoclienteList', {
                
                url: '/infocliente/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'infocliente.list.html',
                        controller: 'infoclienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);