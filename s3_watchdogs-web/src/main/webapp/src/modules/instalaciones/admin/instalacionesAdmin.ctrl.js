(function (ng) {

    var mod = ng.module("instalacionesAdminModule");

    mod.constant("instalacionesAdminContext", "api/instalaciones");

    mod.controller('instalacionesAdminCtrl', ['$scope', '$http', 'instalacionesAdminContext', '$state',
        function ($scope, $http, instalacionesAdminContext, $state) {
            $http.get("src/data/instalaciones.json").then(function (response) {
                $scope.instalacionesAdminRecords = response.data;
            });
        }]);
})(window.angular);