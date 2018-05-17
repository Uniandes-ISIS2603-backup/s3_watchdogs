(function (ng) {

    var mod = ng.module("perfilModule");

    mod.constant("ClienteContext", "api/clientes");
    mod.controller('perfilCtrl', ['$scope', '$http', 'ClienteContext', '$state',
        function ($scope, $http, ClienteContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
                console.log($state.params.rol);
                var comparar = $state.params.rol;

                if (comparar==="cliente") {
                    var idCliente = $state.params.clienteId;
                    $http.get(ClienteContext + '/' + $state.params.clienteId).then(function (response) {
                        $scope.clienteRecords = response.data;
                    });
                } else if (comparar==="assistant" || comparar==="admin") {
                    var idCliente = $state.params.clienteId;
                    console.log(idCliente);
                    $http.get("api/empleados" + '/' + $state.params.clienteId).then(function (response) {
                        $scope.clienteRecords = response.data;
                    });
                }
            }
        }]);
})(window.angular);