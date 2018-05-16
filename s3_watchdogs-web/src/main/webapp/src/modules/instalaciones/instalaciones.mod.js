/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    
    var mod = ng.module("instalacionesModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/instalaciones/';
            
            $urlRouterProvider.otherwise("/instalacionesList");
            
            $stateProvider.state('instalacionesList', {
                
                url: '/instalaciones/list',
                views: {
                    'completeView': {
                        templateUrl: basePath + 'instalaciones.list.html',
                        controller: 'instalacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('veterinariaDetail',{
                url:'/instalaciones/list/veterinariia/detail',
                views:{
                    'mainView':{
                        templateUrl: basePath + 'veterinaria.detail.html',
                        controller:'instalacionesCtrl',
                        controllerAs: 'ctrl' 
                    }
                }
                
            }).state('centroEntrenamientoDetail',{
                url:'/instalaciones/list/centroEntrenamiento/detail',
                views:{
                    'mainView':{
                        templateUrl: basePath + 'centroEntrenamiento.detail.html',
                        controller:'instalacionesCtrl',
                        controllerAs: 'ctrl' 
                    }
                }
                
            })
            ;
    }]);
})(window.angular);
