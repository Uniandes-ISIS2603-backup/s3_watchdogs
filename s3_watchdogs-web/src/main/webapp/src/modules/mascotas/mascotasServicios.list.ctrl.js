(function (ng) {
    
    var mod = ng.module("mascotasModule");
    
    mod.constant("mascotasServiciosContext", "api/mascotas");
    mod.controller('mascotasServiciosCtrl', ['$scope', '$http', 'mascotasServiciosContext', '$state',
        function ($scope, $http, mascotasServiciosContext, $state) {
            if(($state.params.mascotaId !== undefined) && ($state.params.mascotaId !== null)){
            $http.get(mascotasServiciosContext + '/' + $state.params.mascotaId + '/servicios').then(function (response) {
                $scope.mascotasServiciosRecords = response.data;
            
            });
        }
        }]);
})(window.angular);


