(function (ng) {

    var mod = ng.module("empleadosModule");

    mod.constant("empleadosContext", "api/empleados");

    mod.controller('empleadosCtrl', ['$scope', '$http', 'empleadosContext', '$state',
        function ($scope, $http, empleadosContext, $state) {
            $http.get(empleadosContext).then(function (response) {
                $scope.empleadosRecords = response.data;
            });
        }]);
})(window.angular);