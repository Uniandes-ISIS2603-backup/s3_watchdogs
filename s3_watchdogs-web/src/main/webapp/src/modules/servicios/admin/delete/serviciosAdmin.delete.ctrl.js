(function (ng) {
    var mod = ng.module("serviciosAdminModule");
    mod.constant("serviciosAdminContext", "api/servicios");
    mod.controller('servicioAdminDeleteCtrl', ['$scope', '$http', 'serviciosAdminContext', '$state',
        function ($scope, $http, serviciosAdminContext, $state) {
            var idServicio = $state.params.servicioId;
            $scope.deleteServicio = function () {
                $http.delete(serviciosAdminContext + '/' + idServicio, {}).then(function (response) {
                    $state.go('serviciosAdminList', {servicioId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);