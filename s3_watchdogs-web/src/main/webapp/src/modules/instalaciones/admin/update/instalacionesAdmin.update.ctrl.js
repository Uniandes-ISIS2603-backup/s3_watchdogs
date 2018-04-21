(function (ng) {
    var mod = ng.module("instalacionesAdminModule");
    mod.constant("instalacionesAdminContext", "api/instalacionesAdmin");
    mod.controller('instalacionUpdateCtrl', ['$scope', '$http', 'instalacionesAdminContext', '$state', '$rootScope',
        function ($scope, $http, instalacionesAdminContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.aviableItems = [];

            var idinstalacionAdmin = $state.params.instalacionId;

            $http.get(instalacionesAdminContext + '/' + idinstalacionAdmin).then(function (response) {
                var instalacion = response.data;
                $scope.data.name = instalacion.name;
                $scope.data.cedula = instalacion.cedula;
                $scope.data.correo = instalacion.correo;
                $scope.data.imagen = instalacion.imagen;
                $scope.data.telefono = instalacion.telefono;
            });

            $scope.createinstalacionAdmin = function () {
                $http.put(instalacionesAdminContext + "/" + idinstalacionAdmin, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(instalacionesAdminContext + "/" + response.data.id + "/instalacionesAdmin", $scope.selectedItems).then(function (response) {
                        });
                    }
                    $state.go('instalacionesAdminList', {instalacionId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);