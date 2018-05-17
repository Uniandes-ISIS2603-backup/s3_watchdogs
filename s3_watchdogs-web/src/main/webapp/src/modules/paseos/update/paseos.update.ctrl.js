/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("paseosModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("paseosContext", "api/paseos");
            mod.constant("empleadosContext", "api/empleados");
            mod.controller('paseoUpdateCtrl', ['$scope', '$http', 'clientesContext', 'paseosContext', 'empleadosContext', '$state', '$rootScope',
                function ($scope, $http, clientesContext, paseosContext, empleadosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};
                    $scope.mascotas = {};
                    $scope.empleados = {};

                    var idPaseo = $state.params.paseoId;
                    var idCliente = $state.params.clienteId;

                    $http.get(empleadosContext+'/4/cargo').then(function (response) {
                          $scope.empleados = response.data;
                    });

                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.data.cliente = cliente;
                        $scope.mascotas = cliente.mascotas;
                    });

                    $http.get(clientesContext + '/' + idCliente + '/servicios/' + idPaseo).then(function (response) {
                        var paseo = response.data;

                    });

                    $scope.createPaseo = function () {
                        $http.put(paseosContext + "/" + idPaseo, $scope.data).then(function (response) {
                            $state.go('serviciosList', {paseoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

