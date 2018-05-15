(function (ng) {
    
    var mod = ng.module("empleadosAdminModule");
    
    mod.constant("empleadosAdminListContext", "api/clientes");
    mod.controller('empleadoAdminServiciosListCtrl', ['$scope', '$http', 'empleadosAdminListContext', '$state',
        function ($scope, $http, empleadosAdminListContext, $state) {
            if(($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)){
                console.log(empleadosAdminListContext);
            $http.get(empleadosAdminListContext + '/' + $state.params.empleadoId + '/servicios').then(function (response) {
                $scope.adminEmpleadoServiciosRecords = response.data;
            
            });
        }
        }]);
})(window.angular);


