(function (ng) {

    var mod = ng.module("metodoDePagoModule");

    mod.constant("payPalCreate", "api/paypal");

    mod.controller('payPalCreateCtrl', ['$scope', '$http', 'payPalContext', '$state',
        function ($scope, $http, payPalContext, $state) {

            var input = $state.params;

            var params = JSON.stringify(input);
            console.log(params);

            $http.post(payPalContext, params).then(function (response) {
                $scope.metodosDePagoRecords = response.data;
                console.log($scope.data);
            });
        }
    ]);
})(window.angular);