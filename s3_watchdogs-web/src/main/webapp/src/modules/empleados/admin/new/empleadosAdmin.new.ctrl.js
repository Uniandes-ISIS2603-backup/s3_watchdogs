(function (ng) {
    var mod = ng.module("empleadosAdminModule");
    mod.constant("empleadosAdminContext", "api/empleados");
    mod.controller('empleadoAdminNewCtrl', ['$scope', '$http', 'empleadosAdminContext', '$state', 'rootScope',
        function ($scope, $http, empleadosAdminContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.data = {};

            $scope.createEmpleado = function () {
                $http.post(empleadosAdminContext, $scope.data).then(function (response) {
                    $state.go('empleadosAdminList', {empleadoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);