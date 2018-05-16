(function (ng) {

    var mod = ng.module("infosModule");

    mod.controller('infosCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('data/infos.json').then(function (response) {
                $scope.serviciosRecords = response.data;
            });
        }
    ]);
})(window.angular);