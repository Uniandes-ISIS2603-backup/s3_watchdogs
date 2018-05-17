/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("transportesContext", "api/transportes");
    mod.controller('hotelDetailCtrl', ['$scope', '$http', 'clientesContext', 'hotelesContext', 'transportesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, hotelesContext, transportesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            $scope.serviciosN = {};
            $scope.hoteles = {};
            $scope.servicios = {};
            $scope.transportes = {};
            
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
            
            $http.get(transportesContext).then(function(response){
                $scope.transportes = response.data;
            });

            $scope.cambiarF = function () {
                $rootScope.edit = true;

            };
            
            $scope.cambiarV = function () {
                $rootScope.edit = false;

            };
            
            $scope.getHotel = function(idHotel){
                
                for(var i=0; i<$scope.hoteles.length; i++){
                    if($scope.hoteles[i].id == idHotel){
                        return $scope.hoteles[i];
                    }
                }
            }
            
            $scope.actualizar = function (idHotel) {
                console.log($scope.getHotel(idHotel));
                $http.put(hotelesContext + "/" + idHotel, $scope.getHotel(idHotel));
            };
            


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

