/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("empleadosModule");

    mod.constant("empleadosContext", "api/empleados");
    mod.controller('empleadosCtrl', ['$scope', '$http', 'empleadosContext',
        function ($scope, $http, empleadosContext) {
            $http.get('src/data/empleados.json').then(function (response) {
                $scope.empleadosRecords = response.data;
            });
        }
    ]);
})(window.angular);