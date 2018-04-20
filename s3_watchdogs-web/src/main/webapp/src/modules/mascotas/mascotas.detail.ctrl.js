(function (ng) {
    var mod = ng.module("mascotaModule");
    mod.constant("mascotasContext", "api/mascotas");
    mod.controller('mascotaDetailCtrl', ['$scope', '$http', 'mascotasContext', '$state',
    function ($scope, $http, mascotasContext, $state) {
        if(($state.params.mascotaId !== undefined) && ($state.params.mascotaId !== null)) {
            $http.get('src/data/mascotas.json').then(function (response) {
                    
                $scope.currentMascota = response.data;
            });
        }
    }]);
})(window.angular);