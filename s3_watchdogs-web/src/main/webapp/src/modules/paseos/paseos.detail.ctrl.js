/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("paseosContext", "api/paseos");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("rutasContext", "api/rutas");
    mod.controller('paseoDetailCtrl', ['$scope', '$http', 'clientesContext', 'paseosContext', 'rutasContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, paseosContext, rutasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            $scope.serviciosN = {};
            $scope.paseos = {};
            $scope.servicios = {};
            $scope.rutas = {};
            
            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                
                $scope.mascotas = cliente.mascotas;
                $scope.serviciosN = cliente.servicios;
            });

            $http.get(paseosContext).then(function (response) {
                $scope.paseos = response.data;
            });
            
            $http.get(rutasContext).then(function(response){
                $scope.rutas = response.data;
            });

            $scope.cambiarF = function () {
                $rootScope.edit = true;

            };
            
            $scope.cambiarV = function () {
                $rootScope.edit = false;

            };
            
            $scope.getPaseo = function(idPaseo){
                
                for(var i=0; i<$scope.paseos.length; i++){
                    if($scope.paseos[i].id == idPaseo){
                        return $scope.paseos[i];
                    }
                }
            }
            
            $scope.actualizar = function (idPaseo) {
                console.log($scope.getPaseo(idPaseo));
                $http.put(paseosContext + "/" + idPaseo, $scope.getPaseo(idPaseo));
            };
            


            /**var a = $scope.paseos;
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

