/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientosModule");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.controller('entrenamientoDetailCtrl', ['$scope', '$http', 'entrenamientosContext', '$state',
        function ($scope, $http, entrenamientosContext, $state) {
            if (($state.params.entrenamientoId !== undefined) && ($state.params.entrenamientoId !== null)) {
                $http.get(entrenamientosContext + '/' + $state.params.entrenamientoId).then(function (response) {
                    $scope.currentEntrenamiento = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


