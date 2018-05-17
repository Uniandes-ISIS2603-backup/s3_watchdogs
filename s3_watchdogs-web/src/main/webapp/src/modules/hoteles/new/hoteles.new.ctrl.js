/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelNewCtrl', ['$scope', '$http','clientesContext', 'hotelesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, hotelesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            
            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
            });

            $scope.createHotel = function () {
                $http.post(hotelesContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

