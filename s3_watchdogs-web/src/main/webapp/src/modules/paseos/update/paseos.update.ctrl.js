/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("paseosModule");
            mod.constant("paseosContext", "api/paseos");
            mod.controller('paseoUpdateCtrl', ['$scope', '$http', 'paseosContext', '$state', '$rootScope',
                function ($scope, $http, paseosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};

                    var idpaseo = $state.params.paseoId;

                    $http.get(paseosContext + '/' + idpaseo).then(function (response) {
                        var paseo = response.data;
                        $scope.data.name = paseo.name;
                    });


                    $scope.createpaseo = function () {
                        $http.put(paseosContext + "/" + idpaseo, $scope.data).then(function (response) {
                            $state.go('serviciosList', {paseoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

