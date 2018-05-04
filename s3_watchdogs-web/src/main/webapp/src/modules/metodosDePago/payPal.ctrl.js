(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("payPalContext", "api/clientes");
    mod.controller('payPalCtrl', ['$scope', '$http', 'payPalContext', '$state',
        function ($scope, $http, payPalContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){
                console.log(payPalContext);
            $http.get(payPalContext + '/' + $state.params.clienteId + '/payPal').then(function (response) {
                $scope.payPalRecords = response.data;
            
            });
        }
        }]);
})(window.angular);


