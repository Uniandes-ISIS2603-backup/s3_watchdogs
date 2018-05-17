/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("aseosModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("aseosContext", "api/aseos");
            mod.constant("empleadosContext", "api/empleados");
            mod.controller('aseoUpdateCtrl', ['$scope', '$http', 'clientesContext', 'aseosContext', 'empleadosContext', '$state', '$rootScope',
                function ($scope, $http, clientesContext, aseosContext, empleadosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};
                    $scope.mascotas = {};
                    $scope.empleados = {};

                    var idAseo = $state.params.aseoId;
                    var idCliente = $state.params.clienteId;

                    $http.get(empleadosContext+'/3/cargo').then(function (response) {
                          $scope.empleados = response.data;
                    });

                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.data.cliente = cliente;
                        $scope.mascotas = cliente.mascotas;
                    });

                    $scope.createAseo = function () {
                        $http.put(aseosContext + "/" + idAseo, $scope.data).then(function (response) {
                            $state.go('serviciosList', {aseoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);



