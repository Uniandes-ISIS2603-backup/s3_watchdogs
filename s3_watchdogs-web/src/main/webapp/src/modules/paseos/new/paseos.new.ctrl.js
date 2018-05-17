/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("paseosContext", "api/paseos");
    mod.constant("rutasContext", "api/rutas");
    mod.controller('paseoNewCtrl', ['$scope', '$http','clientesContext', 'paseosContext','rutasContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, paseosContext,rutasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            $scope.rutas = {};
            
            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
            });
            
            $http.get(rutasContext).then(function(response){
                $scope.rutas = response.data;
            });

            $scope.createPaseo = function () {
                $http.post(paseosContext, $scope.data)
                
            };
        }
    ]);
}
)(window.angular);

