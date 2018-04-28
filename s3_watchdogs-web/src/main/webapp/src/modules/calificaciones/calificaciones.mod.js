/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("calificacionesModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlRouterProvider.otherwise("/calificacionDetail");
            
            $stateProvider.state('calificacionCreate', {
                url: '/entrenamientos/{entrenamientoId:int}/calificaciones/create',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/calificaciones.new.html',
                        controller: 'calificacionesNewCtrl'
                    }
                }
            });
        }]);
})(window.angular);