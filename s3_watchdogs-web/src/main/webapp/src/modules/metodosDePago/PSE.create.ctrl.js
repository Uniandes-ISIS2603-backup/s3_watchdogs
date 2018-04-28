(function (ng) {

    var mod = ng.module("metodoDePagoModule");

    mod.constant("PSECreate", "api/pses");

    mod.controller('PSECreateCtrl', ['$scope', '$http', 'PSEContext', '$state',
        function ($scope, $http, PSEContext, $state) {

            var input = $state.params;

            var params = JSON.stringify(input);
            console.log(params);

            $http.post(PSEContext, params).then(function (response) {
                $scope.metodosDePagoRecords = response.data;
                console.log($scope.data);
            });
        }
    ]);
})(window.angular);