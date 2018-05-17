(function (ng) {

    var mod = ng.module("clientesModule");
    mod.constant("clienteMascotaCreateContext", "api/clientes");
    mod.controller('clienteMascotasCreateCtrl', ['$scope', '$http', 'clienteMascotaCreateContext', '$state',
        function ($scope, $http, clienteMascotaCreateContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {

                var input = $state.params;
                var params = JSON.stringify(input);

                $http.post(clienteMascotaCreateContext + '/' + $state.params.clienteId + '/mascotas', params).then(function (response) {

                    $scope.clienteMascotasRecords = response.data;
                });
            }
        }]);
})(window.angular);




