(function (ng) {
    
    var mod = ng.module("serviciosAdminModule");
    
    mod.constant("serviciosAdminContext", "api/servicios");
    mod.controller('servicioAdminDetailCtrl', ['$scope', '$http', 'serviciosAdminContext', '$state',
    function ($scope, $http, serviciosAdminContext, $state) {
        if(($state.params.servicioId !== undefined) && ($state.params.servicioId !== null)) {
            $http.get(serviciosAdminContext + '/' + $state.params.servicioId).then(function (response) {
                $scope.currentAdminServicio = response.data;
            });
        }
    }]);
})(window.angular);