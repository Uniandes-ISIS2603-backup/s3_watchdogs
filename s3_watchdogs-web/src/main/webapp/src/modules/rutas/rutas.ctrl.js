(function (ng) {

    var mod = ng.module("rutaModule");

    mod.constant("rutasContext", "api/rutas");

    mod.controller('rutasCtrl', ['$scope', '$http', 'rutasContext',
        function ($scope, $http, rutasContext) {
            $http.get(rutasContext).then(function (response) {
                $scope.empleadosAdminRecords = response.data;
            });
        }]);
})(window.angular);