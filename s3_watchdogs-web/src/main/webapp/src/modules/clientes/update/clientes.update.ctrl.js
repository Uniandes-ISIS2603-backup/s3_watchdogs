(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.aviableItems = [];

            var idCliente = $state.params.clienteId;

            $http.get(clientesContext + '/' + idCliente).then(function (response) {
                var cliente = response.data;
                $scope.data.name = cliente.name;
                $scope.data.cedula = cliente.cedula;
                $scope.data.correo = cliente.correo;
                $scope.data.imagen = cliente.imagen;
                $scope.data.telefono = cliente.telefono;
            });

            $scope.createCliente = function () {
                $http.put(clientesContext + "/" + idCliente, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(clientesContext + "/" + response.data.id + "/clientes", $scope.selectedItems).then(function (response) {
                        });
                    }
                    $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);