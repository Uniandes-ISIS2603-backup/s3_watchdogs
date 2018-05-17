/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("instalacionesModule");

    mod.constant("centroEntrenamientoContext", "api/centrosDeEntrenamiento");

    mod.controller('centroEntrenamientoCtrl', ['$scope', '$http', 'centroEntrenamientoContext', '$state',
        function ($scope, $http, centroEntrenamientoContext, $state) {
            $http.get(centroEntrenamientoContext).then(function (response) {
                $scope.centrosDeEntrenamientosRecords = response.data;
            });
        }]);
})(window.angular);
