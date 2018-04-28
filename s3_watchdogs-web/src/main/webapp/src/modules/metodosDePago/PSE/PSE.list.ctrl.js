(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("metodoDePagoContext", "api/pse");
    mod.controller('PSECtrl', ['$scope', '$http', 'metodoDePagoContext',
        function ($scope, $http, payPalContext) {
            $http.get('src/data/payPal.json').then(function (response) {
                $scope.payPalRecords = response.data;
            });
        }
    ]);
})(window.angular);


