(function (ng) {
    var mod = ng.module("serviciosAdminModule");
    mod.constant("serviciosAdminContext", "api/servicios");
    mod.controller('servicioAdminNewCtrl', ['$scope', '$http', 'serviciosAdminContext', '$state', 'rootScope',
        function ($scope, $http, serviciosAdminContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.data = {};

            $scope.createServicio = function () {
                $http.post(serviciosAdminContext, $scope.data).then(function (response) {
                    $state.go('serviciosAdminList', {servicioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);