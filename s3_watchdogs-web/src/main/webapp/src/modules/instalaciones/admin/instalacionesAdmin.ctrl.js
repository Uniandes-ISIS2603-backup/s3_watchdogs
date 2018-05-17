(function (ng) {

    var mod = ng.module("instalacionesAdminModule");

    mod.controller('instalacionesAdminCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $scope.instalacionesAdminRecords = [];
            $http.get("api/veterinarias").then(function (response) {
                $scope.instalacionesAdminRecords.push(response.data);
                $http.get("api/centrosDeEntrenamiento").then(function (response) {
                    $scope.instalacionesAdminRecords.push(response.data);
                });
            });
        }]);
})(window.angular);