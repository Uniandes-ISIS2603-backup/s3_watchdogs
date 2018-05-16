/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("entrenamientosModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("entrenamientosContext","api/entrenamientos");
            mod.controller('entrenamientoUpdateCtrl', ['$scope', '$http', 'clientesContext','entrenamientosContext', '$state', '$rootScope',
                function ($scope, $http, clientesContext,entrenamientosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    $scope.data = {};
                    $scope.mascotas = {};

                    var idEntrenamiento = $state.params.entrenamientoId;
                    var idCliente = $state.params.clienteId;


                    $http.get(clientesContext + '/' + idCliente + '/entrenamientos/'+ idEntrenamiento  ).then(function (response) {
                        var entrenamiento = response.data;
                        $scope.data.name = entrenamiento.name;
                        $scope.data.fecha = entrenamiento.fecha;
                    });



                    $scope.createentrenamiento = function () {
                        $http.put(entrenamientosContext + "/" + idEntrenamiento, $scope.data).then(function (response) {
                            $state.go('serviciosList', {entrenamientoId: response.data.id}, {reload: true});
                        });
                    }
                }]);
        }
)(window.angular);

