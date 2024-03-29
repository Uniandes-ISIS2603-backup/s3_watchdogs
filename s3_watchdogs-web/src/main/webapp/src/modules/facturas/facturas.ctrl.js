(function (ng) {

    var mod = ng.module("facturasModule");

    mod.constant("facturasContext", "api/facturas");

    mod.controller('facturasCtrl', ['$scope', '$http', 'facturasContext',
        function ($scope, $http, facturasContext) {
            $http.get(facturasContext).then(function (response) {
                $scope.facturasRecords = response.data;
            });
        }]);
})(window.angular);