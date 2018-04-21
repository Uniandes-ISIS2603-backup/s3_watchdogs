/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientosModule");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.controller('entrenamientoDeleteCtrl', ['$scope', '$http', 'entrenamientosContext', '$state',
        function ($scope, $http, entrenamientosContext, $state) {
            var identrenamiento = $state.params.entrenamientoId;
            $scope.deleteentrenamiento = function () {
                $http.delete(entrenamientosContext + '/' + identrenamiento, {}).then(function (response) {
                    $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

