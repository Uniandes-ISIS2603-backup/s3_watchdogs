/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("aseosModule");
    mod.constant("aseosContext", "api/aseos");
    mod.controller('aseoDeleteCtrl', ['$scope', '$http', 'aseosContext', '$state',
        function ($scope, $http, aseosContext, $state) {
            var idaseo = $state.params.aseoId;
            $scope.deleteaseo = function () {
                $http.delete(aseosContext + '/' + idaseo, {}).then(function (response) {
                    $state.go('serviciosList', {aseoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

