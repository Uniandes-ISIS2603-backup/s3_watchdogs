(function (ng) {
    var mod = ng.module("rutaModule");
    mod.constant("rutasContext", "api/rutas");
    mod.controller('rutaNewCtrl', ['$scope', '$http', 'rutasContext', '$state', '$rootScope',
       
        function ($scope, $http, rutasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
            
            $scope.createRuta = function () {
                $http.post(rutasContext, $scope.data).then(function (response) {
                    $state.go('rutasList', {rutasId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
