/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    
    var mod = ng.module("empleadosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/empleados/';
            
            $urlRouterProvider.otherwise("/empleadosList");
            
            $stateProvider.state('empleadosList', {
                
                url: '/empleados/list',
                views: {
                    'completeView': {
                        templateUrl: basePath + 'empleados.list.html',
                        controller: 'empleadosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);
