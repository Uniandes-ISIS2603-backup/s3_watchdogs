(function (ng) {
    var mod = ng.module("hotelModule");
    mod.constant("hotelesContext", "api/hoteles");
    mod.controller('hotelUpdateCtrl', ['$scope', '$http', 'hotelesContext', '$state', '$rootScope',
        
        function ($scope, $http, hotelesContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};
                        $scope.mascotas = {};


            $scope.selectedItems = [];

            $scope.availableItems = [];

            var idHotel = $state.params.hotelId;

            $http.get(hotelesContext + '/' + idHotel).then(function (response) {
                var hotel = response.data;
                $scope.data = hotel;
            });

            

            
            $scope.createHotel = function () {
                $http.put(hotelesContext + "/" + idHotel, $scope.data).then(function (response) {
                    
                    $state.go('serviciosList', {hotelId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);