(function (ng) {
    var mod = ng.module("rutaModule");
    mod.constant("rutaContext", "api/rutas");
    mod.controller('rutaNewCtrl', ['$scope', '$http', 'rutasContext', '$state', '$rootScope',
       
        function ($scope, $http, rutaContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            
            $scope.createRuta = function () {
                $http.post(rutaContext, $scope.data).then(function (response) {
                    $state.go('rutasList', {rutasId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
