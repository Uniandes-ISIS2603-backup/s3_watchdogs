(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("payPalContext", "api/paypal");
    mod.controller('payPalCtrl', ['$scope', '$http', 'payPalContext', '$state',
        function ($scope, $http, payPalContext, $state) {
            $http.get(payPalContext).then(function (response) {
                $scope.metodosDePagoRecords = response.data;
            });
        }
    ]);
})(window.angular);


