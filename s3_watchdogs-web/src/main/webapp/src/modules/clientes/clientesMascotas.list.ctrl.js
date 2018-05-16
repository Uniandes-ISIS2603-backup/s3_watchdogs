(function (ng) {
    
    var mod = ng.module("clientesModule");
    
    mod.constant("clientesMascotasContext", "api/clientes");
    mod.controller('clienteMascotasCtrl', ['$scope', '$http', 'clientesMascotasContext', '$state',
        function ($scope, $http, clientesMascotasContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){
                console.log(clientesMascotasContext);
            $http.get(clientesMascotasContext + '/' + $state.params.clienteId + '/mascotas').then(function (response) {
                $scope.clientesMascotasRecords = response.data;
            
            });
        }
        }]);
})(window.angular);