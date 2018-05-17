(function (ng) {

    var mod = ng.module("serviciosAdminModule");

    mod.controller('serviciosAdminCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $scope.serviciosAseosRecords = [];
            $http.get("api/hoteles").then(function (response) {
                $scope.serviciosAseosRecords.push(response.data);
                $http.get("api/paseos").then(function (response) {
                    $scope.serviciosAseosRecords.push(response.data);
                    $http.get("api/aseos").then(function (response) {
                        $scope.serviciosAseosRecords.push(response.data);
                        $http.get("api/entrenamientos").then(function (response) {
                            $scope.serviciosAseosRecords.push(response.data);
                        });
                    });
                });
            });
        }]);
})(window.angular);