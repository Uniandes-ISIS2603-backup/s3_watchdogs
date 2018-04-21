(function (ng) {
    var mod = ng.module("mascotasModule");
    mod.constant("mascotasContext", "api/mascotas");
    mod.controller('mascotasUpdateCtrl', ['$scope', '$http', 'mascotasContext', '$state', '$rootScope',
        function ($scope, $http, mascotasContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.aviableItems = [];

            var idMascota = $state.params.mascotaId;

            $http.get(mascotasContext + '/' + idMascota).then(function (response) {
                var mascota = response.data;
                $scope.data.color = mascota.color;
                $scope.data.name = mascota.name;
                $scope.data.raza = mascota.raza;
                $scope.data.sexo = mascota.sexo;
            });

            $scope.createMascota = function () {
                $http.put(mascotasContext + "/" + idMascota, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(mascotasContext + "/" + response.data.id + "/mascotas", $scope.selectedItems).then(function (response) {
                        });
                    }
                    $state.go('mascotasList', {mascotaId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);