(function (ng) {

    var mod = ng.module("metodoDePagoModule");

    mod.constant("PSEContext", "api/clientes");

    mod.controller('PSECreateCtrl', ['$scope', '$http', 'PSEContext', '$state',
        function ($scope, $http, PSEContext, $state) {
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {

                var input = $state.params;

                var params = JSON.stringify(input);

                $http.post(PSEContext + '/' + $state.params.clienteId + '/PSE', params).then(function (response) {
                    $scope.metodosDePagoRecords = response.data;

                });
            }
        }]);
})(window.angular);