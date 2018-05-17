(function (ng) {
    
    var mod = ng.module("empleadosAdminModule");
    
    mod.constant("empleadosAdminListContext", "api/empleados");
    mod.controller('empleadoAdminServiciosListCtrl', ['$scope', '$http', 'empleadosAdminListContext', '$state',
        function ($scope, $http, empleadosAdminListContext, $state) {
            if(($state.params.empleadoId !== undefined) && ($state.params.empleadoId !== null)){

            $http.get(empleadosAdminListContext + '/' + $state.params.empleadoId + '/servicios').then(function (response) {
                $scope.adminEmpleadoServiciosRecords = response.data;
            
            });
        }
        }]);
})(window.angular);


