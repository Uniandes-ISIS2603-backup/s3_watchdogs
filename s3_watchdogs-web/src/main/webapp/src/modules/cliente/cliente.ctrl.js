(function (ng) {

    var mod = ng.module("clienteModule");

    mod.constant("clienteContext", "api/cliente");

    mod.controller('clienteCtrl', ['$scope', '$http', 'clienteContext',
        function ($scope, $http, clienteContext) {
            $http.get('data/cliente.json').then(function (response) {
                $scope.clienteRecords = response.data;
            });
        }]);
})(window.angular);