/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientosModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.controller('entrenamientoNewCtrl', ['$scope', '$http', 'clientesContext', 'entrenamientosContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, entrenamientosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};

            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
            });

            $scope.createEntrenamiento = function () {
                $http.post(clientesContext+'/'+idCliente+'/entrenamientos', $scope.data).then(function (response) {
                    $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
