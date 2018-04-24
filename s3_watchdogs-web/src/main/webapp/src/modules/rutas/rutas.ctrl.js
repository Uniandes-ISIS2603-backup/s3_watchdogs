(function (ng) {
    var mod = ng.module("rutaModule");
    mod.constant("rutaContext", "api/rutas");
    mod.controller('rutaCtrl', ['$scope', '$http', 'rutaContext',
        function ($scope, $http, rutaContext) {
            $http.get('data/rutas.json').then(function (response) {
                $scope.rutasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);