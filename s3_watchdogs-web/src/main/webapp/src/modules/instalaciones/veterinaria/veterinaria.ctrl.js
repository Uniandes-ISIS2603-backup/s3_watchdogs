(function (ng) {

    var mod = ng.module("instalacionesModule");

    mod.constant("veterinariaContext", "api/veterinarias");

    mod.controller('veterinariaCtrl', ['$scope', '$http', 'veterinariaContext', '$state',
        function ($scope, $http, veterinariaContext, $state) {
            $http.get(veterinariaContext).then(function (response) {
                $scope.veterinariasRecords = response.data;
            });
        }]);
})(window.angular);