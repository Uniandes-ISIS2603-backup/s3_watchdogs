/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionesNewCtrl', ['$scope', '$http', 'entrenamientosContext', 'calificacionesContext', '$state', '$rootScope',
        function ($scope, $http, entrenamientosContext, calificacionesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            var idEntrenamiento = $state.params.entrenamientoId;


            $scope.createCalificacion = function () {
                $http.post(entrenamientosContext+'/'+idEntrenamiento+'/calificaciones', $scope.data).then(function (response) {
                    $state.go('serviciosList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);



