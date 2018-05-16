/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("paseosContext", "api/paseos");
    mod.controller('paseoNewCtrl', ['$scope', '$http', 'clientesContext','paseosContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, paseosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            $scope.mascotas = {};
            
            var idCliente = $state.params.clienteId;
            
             $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.cliente = cliente;
                $scope.mascotas = cliente.mascotas;
            });
                    
            $scope.createpaseo = function () {
                $http.post(clientesContext+'/'+idCliente+'/paseos', $scope.data).then(function (response) {
                    $state.go('serviciosList', {paseoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

