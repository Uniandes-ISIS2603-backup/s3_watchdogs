/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("hotelesModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("hotelsContext", "api/hotels");
            mod.constant("empleadosContext", "api/empleados");
            mod.controller('hotelUpdateCtrl', ['$scope', '$http', 'clientesContext', 'hotelsContext', 'empleadosContext', '$state', '$rootScope',
                function ($scope, $http, clientesContext, hotelsContext, empleadosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};
                    $scope.mascotas = {};
                    $scope.empleados = {};

                    var idHotel = $state.params.hotelId;
                    var idCliente = $state.params.clienteId;

                    $http.get(empleadosContext+'/2/cargo').then(function (response) {
                          $scope.empleados = response.data;
                    });

                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.data.cliente = cliente;
                        $scope.mascotas = cliente.mascotas;
                    });

                    $http.get(clientesContext + '/' + idCliente + '/servicios/' + idHotel).then(function (response) {
                        var hotel = response.data;

                    });

                    $scope.createHotel = function () {
                        $http.put(hotelsContext + "/" + idHotel, $scope.data).then(function (response) {
                            $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

