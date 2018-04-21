(function (ng) {
    var mod = ng.module("mascotasModule");
    mod.constant("mascotasContext", "api/mascotas");
    mod.controller('mascotaNewCtrl', ['$scope', '$http', 'mascotasContext', '$state', 'rootScope',
        function ($scope, $http, mascotasContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.data = {};

            $scope.createMascota = function () {
                $http.post(mascotasContext, $scope.data).then(function (response) {
                    $state.go('mascotasList', {mascotaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);