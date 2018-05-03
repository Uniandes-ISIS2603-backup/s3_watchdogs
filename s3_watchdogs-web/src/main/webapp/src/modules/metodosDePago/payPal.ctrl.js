(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("payPalContext", "api/clientes");
    mod.controller('payPalCtrl', ['$scope', '$http', 'payPalContext', '$state',
        function ($scope, $http, payPalContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){
                
            $http.get(payPalContext + '/' + $state.params.clienteId).then(function (response) {
                $scope.metodosDePagoRecords = response.data;
            
            });
        }
        }]);
})(window.angular);


