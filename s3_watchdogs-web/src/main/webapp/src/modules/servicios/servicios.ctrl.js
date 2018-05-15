(function (ng) {

    var mod = ng.module("serviciosModule");

    mod.controller('serviciosCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('data/servicios.json').then(function (response) {
                $scope.serviciosRecords = response.data;
            });
        }
    ]);
})(window.angular);