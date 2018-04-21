(function (ng) {
    
    var mod = ng.module("empleadosAdminModule");
    
    mod.constant("empleadosAdminContext", "api/empleados");
    mod.controller('empleadoAdminDetailCtrl', ['$scope', '$http', 'empleadosAdminContext', '$state',
    function ($scope, $http, empleadosAdminContext, $state) {
        if(($state.params.empleadoId !== undefined) && ($state.params.empleadoId !== null)) {
            $http.get(empleadosAdminContext + '/' + $state.params.empleadoId).then(function (response) {
                $scope.currentAdminEmpleado = response.data;
            });
        }
    }]);
})(window.angular);