/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelDetailCtrl', ['$scope', '$http', 'clientesContext', 'hotelesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, hotelesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            $scope.serviciosN = {};
            $scope.hoteles = {};
            $scope.servicios = {};

            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
                $scope.serviciosN = cliente.servicios;
            });

            $http.get(hotelesContext).then(function (response) {
                $scope.hoteles = response.data;       
            });
            

            /**var a = $scope.hoteles;
             var b = $scope.serviciosN;
             for(i = 0; i<a.length; i++){
             for(j =0; j<b.length; j++){
             if(angular.equals(a[i].id, b[j].id)){
             $scope.servicios.push(a[i]);
             }
             }
             }**/


        }
    ]);
}
)(window.angular);

