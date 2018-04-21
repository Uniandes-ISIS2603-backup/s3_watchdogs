(function (ng) {
    var mod = ng.module("empleadosAdminModule");
    mod.constant("empleadosAdminContext", "api/empleados");
    mod.controller('empleadoAdminUpdateCtrl', ['$scope', '$http', 'empleadosAdminContext', '$state', '$rootScope',
        function ($scope, $http, empleadosAdminContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.aviableItems = [];

            var idEmpleado = $state.params.empleadoId;

            $http.get(empleadosAdminContext + '/' + idEmpleado).then(function (response) {
                var empleado = response.data;
                $scope.data.name = empleado.name;
                $scope.data.cedula = empleado.cedula;
                $scope.data.correo = empleado.correo;
                $scope.data.imagen = empleado.imagen;
                $scope.data.telefono = empleado.telefono;
            });

            $scope.createEmpleado = function () {
                $http.put(empleadosAdminContext + "/" + idEmpleado, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(empleadosAdminContext + "/" + response.data.id + "/empleados", $scope.selectedItems).then(function (response) {
                        });
                    }
                    $state.go('empleadosAdminList', {empleadoId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);