/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("paseosContext", "api/paseos");
    mod.controller('paseoDetailCtrl', ['$scope', '$http', 'paseosContext', '$state',
        function ($scope, $http, paseosContext, $state) {
            if (($state.params.paseoId !== undefined) && ($state.params.paseoId !== null)) {
                $http.get(paseosContext + '/' + $state.params.paseoId).then(function (response) {
                    $scope.currentPaseo = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


