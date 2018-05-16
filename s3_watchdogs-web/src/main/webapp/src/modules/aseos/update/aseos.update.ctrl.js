/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("aseosModule");
            mod.constant("aseosContext", "api/aseos");
            mod.controller('aseoUpdateCtrl', ['$scope', '$http', 'aseosContext', '$state', '$rootScope',
                function ($scope, $http, aseosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};

                    var idaseo = $state.params.aseoId;

                    $http.get(aseosContext + '/' + idaseo).then(function (response) {
                        var aseo = response.data;
                        $scope.data.name = aseo.name;
                    });


                    $scope.createaseo = function () {
                        $http.put(aseosContext + "/" + idaseo, $scope.data).then(function (response) {
                            $state.go('serviciosList', {aseoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

