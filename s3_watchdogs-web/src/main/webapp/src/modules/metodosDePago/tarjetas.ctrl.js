(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("tarjetasContext", "api/clientes");
    mod.controller('tarjetasCtrl', ['$scope', '$http', 'tarjetasContext', '$state',
        function ($scope, $http, tarjetasContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){

            $http.get(tarjetasContext + '/' + $state.params.clienteId + '/tarjetasCredito').then(function (response) {
                $scope.tarjetasRecords = response.data;
            
            });
        }
        }]);
})(window.angular);