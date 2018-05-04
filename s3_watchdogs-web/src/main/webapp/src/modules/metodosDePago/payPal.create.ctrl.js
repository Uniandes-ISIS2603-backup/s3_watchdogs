(function (ng) {

    var mod = ng.module("metodoDePagoModule");
    mod.constant("payPalContext", "api/clientes");
    mod.controller('payPalCreateCtrl', ['$scope', '$http', 'payPalContext', '$state',
        function ($scope, $http, payPalContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {

                var input = $state.params;
                var params = JSON.stringify(input);
                console.log(params);
                $http.post(payPalContext + '/' + $state.params.clienteId + '/payPal', params).then(function (response) {
                    $scope.payPalRecords = response.data;
                    console.log($scope.data);
                });
            }
        }]);
})(window.angular);