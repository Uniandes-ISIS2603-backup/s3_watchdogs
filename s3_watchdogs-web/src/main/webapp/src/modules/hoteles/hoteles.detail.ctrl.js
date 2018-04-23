/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelDetailCtrl', ['$scope', '$http', 'hotelesContext', '$state',
        function ($scope, $http, hotelesContext, $state) {
            if (($state.params.hotelId !== undefined) && ($state.params.hotelId !== null)) {
                $http.get(hotelesContext + '/' + $state.params.hotelId).then(function (response) {
                    $scope.currentHotel = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


