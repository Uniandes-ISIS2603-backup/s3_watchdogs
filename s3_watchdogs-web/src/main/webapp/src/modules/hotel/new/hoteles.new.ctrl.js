/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelNewCtrl', ['$scope', '$http', 'hotelesContext', '$state', '$rootScope',
        function ($scope, $http, hotelesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            $scope.createhotel = function () {
                $http.post(hotelesContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

