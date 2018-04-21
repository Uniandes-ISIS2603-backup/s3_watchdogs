(function (ng) {

    var mod = ng.module("serviciosAdminModule");

    mod.constant("serviciosAdminContext", "api/servicios");

    mod.controller('serviciosAdminCtrl', ['$scope', '$http', 'serviciosAdminContext', '$state',
        function ($scope, $http, serviciosAdminContext, $state) {
            $http.get("src/data/servicios.json").then(function (response) {
                $scope.serviciosAdminRecords = response.data;
            });
        }]);
})(window.angular);