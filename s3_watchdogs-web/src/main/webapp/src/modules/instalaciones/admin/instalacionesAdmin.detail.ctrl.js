(function (ng) {
    
    var mod = ng.module("instalacionesAdminModule");
    
    mod.constant("instalacionesAdminContext", "api/instalaciones");
    mod.controller('instalacionAdminDetailCtrl', ['$scope', '$http', 'instalacionesAdminContext', '$state',
    function ($scope, $http, instalacionesAdminContext, $state) {
        if(($state.params.instalacionAdminId !== undefined) && ($state.params.instalacionAdminId !== null)) {
            $http.get(instalacionesAdminContext + '/' + $state.params.instalacionAdminId).then(function (response) {
                $scope.currentAdminInstalacion = response.data;
            });
        }
    }]);
})(window.angular);