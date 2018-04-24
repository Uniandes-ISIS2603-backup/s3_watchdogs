/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("instalacionesModule");

    mod.constant("instalacionesContext", "api/instalaciones");
    mod.controller('instalacionesCtrl', ['$scope', '$http', 'instalacionesContext',
        function ($scope, $http, instalacionesContext) {
            $http.get('src/data/instalaciones.json').then(function (response) {
                $scope.instalacionesRecords = response.data;
            });
        }
    ]);
})(window.angular);

