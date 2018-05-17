/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("entrenamientosModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("entrenamientosContext", "api/entrenamientos");
            mod.constant("empleadosContext", "api/empleados");
            mod.controller('entrenamientoUpdateCtrl', ['$scope', '$http', 'clientesContext', 'entrenamientosContext', 'empleadosContext', '$state', '$rootScope',
                function ($scope, $http, clientesContext, entrenamientosContext, empleadosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};
                    $scope.mascotas = {};
                    $scope.empleados = {};

                    var idEntrenamiento = $state.params.entrenamientoId;
                    var idCliente = $state.params.clienteId;

                    $http.get(empleadosContext+'/1/cargo').then(function (response) {
                          $scope.empleados = response.data;
                    });

                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.data.cliente = cliente;
                        $scope.mascotas = cliente.mascotas;
                    });

                    $http.get(clientesContext + '/' + idCliente + '/servicios/' + idEntrenamiento).then(function (response) {
                        var entrenamiento = response.data;

                    });

                    $scope.createEntrenamiento = function () {
                        $http.put(entrenamientosContext + "/" + idEntrenamiento, $scope.data).then(function (response) {
                            $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

