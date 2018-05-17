(function (ng) {
    
    var mod = ng.module("serviciosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/servicios/';
            
            $urlRouterProvider.otherwise("/serviciosList");
            
            $stateProvider.state('serviciosListC', {
                
                url: '/servicios/{clienteId: int}/list',
                param: {
                    clienteId: null
                },
                views: {
                    'completeView': {
                        templateUrl: basePath + 'servicios.list.html',
                        controller: 'serviciosCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'servicios.nav.html'
                    }
                }
            }).state('serviciosList', {
                
                url: '/servicios/list',
                param: {
                    clienteId: null
                },
                views: {
                    'completeView': {
                        templateUrl: basePath + 'servicios.list.html',
                        controller: 'serviciosCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'servicios.nav.html'
                    }
                }
            }).state('aseoDetail',{
                url:'/servicios/list/aseo/detail',
                views:{
                    'completeView':{
                        templateUrl: basePath + 'aseo.detail.html',
                        controller:'serviciosCtrl',
                        controllerAs: 'ctrl' 
                    },
                    'navView': {
                        templateUrl: basePath + 'servicios.nav.html'
                    }
                }
                
            })
            ;
    }]);
})(window.angular);