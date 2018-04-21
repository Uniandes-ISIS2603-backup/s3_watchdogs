(function (ng) {
    var mod = ng.module("instalacionesAdminModule");
    mod.constant("instalacionesAdminContext", "api/instalacionesAdmin");
    mod.controller('instalacionAdminDeleteCtrl', ['$scope', '$http', 'instalacionesAdminContext', '$state',
        function ($scope, $http, instalacionesAdminContext, $state) {
            var idInstalacionAdmin = $state.params.instalacionAdminId;
            $scope.deleteInstalacionAdmin = function () {
                $http.delete(instalacionesAdminContext + '/' + idInstalacionAdmin, {}).then(function (response) {
                    $state.go('instalacionesAdminList', {instalacionAdminId: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);