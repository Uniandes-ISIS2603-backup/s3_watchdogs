(function (ng) {
    var mod = ng.module("mascotaModule");
    mod.constant("mascotasContext", "api/mascotas");
    mod.controller('mascotaCtrl', ['$scope', '$http', 'mascotasContext', '$state',
    function ($scope, $http, mascotasContext, $state) {
        $http.get('src/data/mascotas.json').then(function (response) {
            $scope.mascotasRecords = response.data;
        });
    }]);
})(window.angular);