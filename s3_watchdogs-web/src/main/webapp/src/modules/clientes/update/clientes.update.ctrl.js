(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
    function ($scope, $http, clientesContext, $state, $rootScope){
        $rootScope.edit = true;
        
        $scope.data = {};
        
        $scope.selectedItems = [];
        
        $scope.aviableItems = [];
        
        var idCliente = $state.params.clienteId;
        
        $http.get(clientesContext + '/' + idCliente).then(function (response) {
            var cliente = response.data;
            $scope.data.name = cliente.name;
            $scope.data.cedula = cliente.cedula;
            
        });
    }]);
})(window.angular);