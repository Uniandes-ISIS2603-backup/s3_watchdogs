(function (ng) {
    var mod = ng.module("disponibilidadModule");
    mod.constant("disponibilidadContext", "api/disponibilidades");
    mod.controller('disponibilidadCtrl', ['$scope', '$http', 'disponibilidadContext',
        function ($scope, $http, disponibilidadContext) {
            $http.get('data/hola.json').then(function (response) {
                $scope.disponibilidadesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);