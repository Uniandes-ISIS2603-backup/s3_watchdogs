/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientosModule");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.controller('entrenamientoNewCtrl', ['$scope', '$http', 'entrenamientosContext', '$state', '$rootScope',
        function ($scope, $http, entrenamientosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            $scope.createentrenamiento = function () {
                $http.post(entrenamientosContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

