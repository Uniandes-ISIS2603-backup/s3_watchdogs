(function (ng) {

    var mod = ng.module("mascotasModule");

    mod.constant("mascotasContext", "api/mascotas");

    mod.controller('mascotasCtrl', ['$scope', '$http', 'mascotasContext', '$state',
        function ($scope, $http, mascotasContext, $state) {
            $http.get(mascotasContext).then(function (response) {
                $scope.mascotasRecords = response.data;
            });
        }]);
})(window.angular);