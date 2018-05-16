/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("aseosModule");
    mod.constant("aseosContext", "api/aseos");
    mod.controller('aseoDetailCtrl', ['$scope', '$http', 'aseosContext', '$state',
        function ($scope, $http, aseosContext, $state) {
            if (($state.params.aseoId !== undefined) && ($state.params.aseoId !== null)) {
                $http.get(aseosContext + '/' + $state.params.aseoId).then(function (response) {
                    $scope.currentAseo = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


