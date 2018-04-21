(function (ng) {
    var mod = ng.module("mascotasModule");
    mod.constant("mascotasContext", "api/mascotas");
    mod.controller('mascotaDeleteCtrl', ['$scope', '$http', 'mascotasContext', '$state',
        function ($scope, $http, mascotasContext, $state) {
            var idMascota = $state.params.mascotaId;
            $scope.deleteMascota = function () {
                $http.delete(mascotasContext + '/' + idMascota, {}).then(function (response) {
                    $state.go('mascotasList', {mascotaId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);