(function (ng) {

    var mod = ng.module("metodoDePagoModule");
    mod.constant("tarjetaCreditoContext", "api/clientes");
    mod.controller('tarjetaCreateCtrl', ['$scope', '$http', 'tarjetaCreditoContext', '$state',
        function ($scope, $http, tarjetaCreditoContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {

                var input = $state.params;
                var params = JSON.stringify(input);
                console.log(params);
                $http.post(tarjetaCreditoContext + '/' + $state.params.clienteId + '/tarjetasCredito', params).then(function (response) {
                    $scope.tarjetasRecords = response.data;
                    console.log($scope.data);
                });
            }
        }]);
})(window.angular);

