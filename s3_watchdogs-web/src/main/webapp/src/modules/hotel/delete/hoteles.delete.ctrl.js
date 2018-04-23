/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("hotelesModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelDeleteCtrl', ['$scope', '$http', 'hotelesContext', '$state',
        function ($scope, $http, hotelesContext, $state) {
            var idhotel = $state.params.hotelId;
            $scope.deletehotel = function () {
                $http.delete(hotelesContext + '/' + idhotel, {}).then(function (response) {
                    $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

