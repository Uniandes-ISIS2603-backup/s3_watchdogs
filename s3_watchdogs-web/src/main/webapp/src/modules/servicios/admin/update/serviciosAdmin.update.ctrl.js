(function (ng) {
    var mod = ng.module("serviciosAdminModule");
    mod.constant("serviciosAdminContext", "api/servicios");
    mod.controller('servicioAdminUpdateCtrl', ['$scope', '$http', 'serviciosAdminContext', '$state', '$rootScope',
        function ($scope, $http, serviciosAdminContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.aviableItems = [];

            var idServicio = $state.params.servicioId;

            $http.get(serviciosAdminContext + '/' + idServicio).then(function (response) {
                var servicio = response.data;
                $scope.data.name = servicio.name;
                $scope.data.cedula = servicio.cedula;
                $scope.data.correo = servicio.correo;
                $scope.data.imagen = servicio.imagen;
                $scope.data.telefono = servicio.telefono;
            });

            $scope.createServicio = function () {
                $http.put(serviciosAdminContext + "/" + idServicio, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(serviciosAdminContext + "/" + response.data.id + "/servicios", $scope.selectedItems).then(function (response) {
                        });
                    }
                    $state.go('serviciosAdminList', {servicioId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);