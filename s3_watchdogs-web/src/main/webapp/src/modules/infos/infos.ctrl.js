(function (ng) {

    var mod = ng.module("infosModule");

    mod.constant("infosContext", "api/infos");
    mod.controller('infosCtrl', ['$scope', '$http', 'infosContext',
        function ($scope, $http, infosContext) {
            $http.get('src/data/infos.json').then(function (response) {
                $scope.infosRecords = response.data;
            });
        }
    ]);
})(window.angular);