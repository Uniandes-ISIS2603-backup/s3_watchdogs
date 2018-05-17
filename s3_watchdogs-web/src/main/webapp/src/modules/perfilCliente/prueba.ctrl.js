(function (ng) {

    var mod = ng.module("perfilModule");

    mod.constant("ClienteContext", "api/clientes");
    mod.controller('perfilCtrl', ['$scope', '$http', 'ClienteContext', '$state',
        function ($scope, $http, ClienteContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
                 var idCliente = $state.params.clienteId;
                 console.log(idCliente);
                $http.get(ClienteContext + '/' + $state.params.clienteId).then(function (response) {
                    $scope.clienteRecords = response.data;
                });
            }
        }]);
})(window.angular);