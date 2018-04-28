(function (ng) {
    var mod = ng.module("empleadosAdminModule");
    mod.constant("empleadosAdminContext", "api/mascotas");
    mod.controller('empleadoAdminDeleteCtrl', ['$scope', '$http', 'empleadosAdminContext', '$state',
        function ($scope, $http, empleadosAdminContext, $state) {
            var idEmpleado = $state.params.empleadoId;
            $scope.deleteEmpleado = function () {
                $http.delete(empleadosAdminContext + '/' + idEmpleado, {}).then(function (response) {
                    $state.go('empleadosAdminList', {empleadoId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);