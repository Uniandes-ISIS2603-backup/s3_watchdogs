(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("PSEContext", "api/clientes");
    mod.controller('PSECtrl', ['$scope', '$http', 'PSEContext', '$state',
        function ($scope, $http, PSEContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){
            $http.get(PSEContext + '/' + $state.params.clienteId + '/PSE').then(function (response) {
                $scope.PSERecords = response.data;
            });
        }
        }]);
})(window.angular);


