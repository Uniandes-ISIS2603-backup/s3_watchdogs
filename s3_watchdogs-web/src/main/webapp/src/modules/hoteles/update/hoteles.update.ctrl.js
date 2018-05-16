/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("hotelesModule");
            mod.constant("hotelesContext", "api/hoteles");
            mod.controller('hotelUpdateCtrl', ['$scope', '$http', 'hotelesContext', '$state', '$rootScope',
                function ($scope, $http, hotelesContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};

                    var idhotel = $state.params.hotelId;

                    $http.get(hotelesContext + '/' + idhotel).then(function (response) {
                        var hotel = response.data;
                        $scope.data.name = hotel.name;
                    });


                    $scope.createhotel = function () {
                        $http.put(hotelesContext + "/" + idhotel, $scope.data).then(function (response) {
                            $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

