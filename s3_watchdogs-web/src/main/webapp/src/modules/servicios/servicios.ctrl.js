(function (ng) {

    var mod = ng.module("serviciosModule");

    mod.constant("serviciosContext", "api/servicios");
    mod.controller('serviciosCtrl', ['$scope', '$http', 'serviciosContext','$state', '$rootScope',
        function ($scope, $http, serviciosContext,$state, $rootScope) {
            $rootScope.cliente = $state.params.clienteId;
            
            $http.get('src/data/servicios.json').then(function (response) {
                $scope.serviciosRecords = response.data;
            });
        }
    ]);
})(window.angular);