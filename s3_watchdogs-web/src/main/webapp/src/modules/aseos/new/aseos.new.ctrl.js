/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("aseosModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("aseosContext", "api/aseos");
    mod.controller('aseoNewCtrl', ['$scope', '$http', 'clientesContext', 'aseosContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, aseosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};

            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
            });

            $scope.createAseo = function () {
                $http.post(clientesContext+'/'+idCliente+'/aseos', $scope.data).then(function (response) {
                    $state.go('serviciosList', {aseoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

