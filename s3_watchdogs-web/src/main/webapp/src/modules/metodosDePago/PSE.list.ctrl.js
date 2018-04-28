(function (ng) {
    
    var mod = ng.module("metodoDePagoModule");
    
    mod.constant("PSEContext", "api/pses");
    mod.controller('PSECtrl', ['$scope', '$http', 'PSEContext', '$state',
        function ($scope, $http, PSEContext, $state) {
            $http.get(PSEContext).then(function (response) {
                $scope.metodosDePagoRecords = response.data;
            });
        }
    ]);
})(window.angular);


