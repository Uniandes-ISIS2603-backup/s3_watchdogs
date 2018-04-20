(function (ng) {
    
    var mod = ng.module("perfilShowModule");
    
    mod.constant("perfilShowContext", "api/perfil");
    mod.controller('perfilShowCtrl', ['$scope', '$http', 'perfilShowContext',
        function($scope, $http, perfilContext) {
            $http.get('src/data/clientes.json').then(function (response) {
                $scope.perfilClienteRecords = response.data;
            });
        }
    ]);
}) (window.angular);
