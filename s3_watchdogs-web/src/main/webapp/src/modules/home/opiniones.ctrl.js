(function (ng) {
    
    var mod = ng.module("opinionesModule");
    
    mod.constant("opinionesContext", "api/opiniones");
    mod.controller('opinionesCtrl', ['$scope', '$http', 'opinionesContext',
        function ($scope, $http, opinionesContext) {
            $http.get('src/data/opiniones.json').then(function (response) {
                $scope.opinionesRecords = response.data;
            });
        }
    ]);
})(window.angular);