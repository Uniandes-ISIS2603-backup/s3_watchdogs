(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("metodoDePagoContext", "api/metodosDePago");
    mod.controller('payPalCtrl', ['$scope', '$http', 'metodoDePagoContext',
        function ($scope, $http, metodosDePagoContext) {
            $http.get('src/data/payPal.json').then(function (response) {
                $scope.metodosDePagoRecords = response.data;
            });
        }
    ]);
})(window.angular);


