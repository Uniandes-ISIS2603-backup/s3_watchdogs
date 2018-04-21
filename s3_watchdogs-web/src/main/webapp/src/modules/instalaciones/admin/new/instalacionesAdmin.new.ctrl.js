(function (ng) {
    var mod = ng.module("instalacionesAdminModule");
    mod.constant("instalacionesAdminContext", "api/instalacionesAdmin");
    mod.controller('instalacionAdminNewCtrl', ['$scope', '$http', 'instalacionesAdminContext', '$state', 'rootScope',
        function ($scope, $http, instalacionesAdminContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.data = {};

            $scope.createInstalacionAdmin = function () {
                $http.post(instalacionesAdminContext, $scope.data).then(function (response) {
                    $state.go('instalacionesAdminList', {instalacionAdminId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);