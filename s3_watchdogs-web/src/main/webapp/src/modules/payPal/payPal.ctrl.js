(function (ng) {
    
    var mod = ng.module("payPalModule");
    
    mod.constant("payPalContext", "api/payPal");
    mod.controller('payPalCtrl', ['$scope', '$http', 'payPalContext',
        function ($scope, $http, payPalContext) {
            $http.get('src/data/payPal.json').then(function (response) {
                $scope.payPalRecords = response.data;
            });
        }
    ]);
})(window.angular);


