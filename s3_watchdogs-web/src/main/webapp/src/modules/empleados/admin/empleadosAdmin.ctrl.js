(function (ng) {

    var mod = ng.module("empleadosAdminModule");

    mod.constant("empleadosAdminContext", "api/empleados");

    mod.controller('empleadosAdminCtrl', ['$scope', '$http', 'empleadosAdminContext', '$state',
        function ($scope, $http, empleadosAdminContext, $state) {
            $http.get(empleadosAdminContext).then(function (response) {
                $scope.empleadosAdminRecords = response.data;
            });
        }]);
})(window.angular);