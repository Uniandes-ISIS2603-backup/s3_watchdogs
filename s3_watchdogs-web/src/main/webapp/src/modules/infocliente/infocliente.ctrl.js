(function (ng) {

    var mod = ng.module("infoclienteModule");

    mod.constant("infoclienteContext", "api/infocliente");
    mod.controller('infoclienteCtrl', ['$scope', '$http', 'infoclienteContext',
        function ($scope, $http, infoclienteContext) {
            $http.get('src/data/infocliente.json').then(function (response) {
                $scope.infoclienteRecords = response.data;
            });
        }
    ]);
})(window.angular);