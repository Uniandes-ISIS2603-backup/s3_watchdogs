/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("paseosModule");
    mod.constant("paseosContext", "api/paseos");
    mod.controller('paseoDeleteCtrl', ['$scope', '$http', 'paseosContext', '$state','$rootScope',
        function ($scope, $http, paseosContext, $state,$rootScope) {
            $rootScope.cliente = $state.params.clienteId;

            var idpaseo = $state.params.paseoId;
            $scope.deletepaseo = function () {
                $http.delete(paseosContext + '/' + idpaseo, {}).then(function (response) {
                    $state.go('serviciosList', {paseoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

