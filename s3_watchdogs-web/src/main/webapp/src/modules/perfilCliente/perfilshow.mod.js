(function (ng) {
    
    var mod = ng.module("perfilShowModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/perfilCliente/';
        
        $urlRouterProvider.otherwise("/perfilShow");
        
        $stateProvider.state('perfilShow', {
            
            url: '/cliente/perfil',
            views: {
                'mainView':{
                    templateUrl: basePath + 'perfil.show.html',
                    controller: 'perfilShowCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
    }]);
}) (window.angular);