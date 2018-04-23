/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("paseosContext", "api/paseos");
    mod.controller('paseoNewCtrl', ['$scope', '$http', 'paseosContext', '$state', '$rootScope',
        function ($scope, $http, paseosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            $scope.createpaseo = function () {
                $http.post(paseosContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {paseoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

