(function (ng) {
    
    var mod = ng.module("clientesModule");
    
    mod.constant("clientesServiciosContext", "api/clientes");
    mod.controller('clienteServiciosCtrl', ['$scope', '$http', 'clientesServiciosContext', '$state',
    function ($scope, $http, clientesServiciosContext, $state) {
        if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {
            $http.get(clientesServiciosContext + '/' + $state.params.clienteId + '/servicios').then(function (response) {
                $scope.clientesServiciosRecords = response.data;
            });
        }
    }]);
})(window.angular);