(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturaContext", "api/facturas");
    mod.controller('facturaCtrl', ['$scope', '$http', 'rutaContext',
        function ($scope, $http, facturaContext) {
            $http.get('src/data/facturasTemp.json').then(function (response) {
                $scope.facturasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

