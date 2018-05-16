(function (ng) {
    
    var mod = ng.module("infosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/infos/';
            
            $urlRouterProvider.otherwise("/infosList");
            
            $stateProvider.state('infosList', {
                
                url: '/infos/list',
                views: {
                    'completeView': {
                        templateUrl: basePath + 'infos.list.html',
                        controller: 'infosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);