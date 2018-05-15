(function (ng) {
    var mod = ng.module("metodoDePagoModule");
    mod.constant("tarjetaContext", "api/clientes");
    mod.controller('tarjetaUpdateCtrl', ['$scope', '$http', 'tarjetaContext', '$state',
        /**
         * @ngdoc controller
         * @name authors.controller:authorDeleteCtrl
         * @description
         * Definición del controlador auxiliar para eliminar Autores. 
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} authorsContext Constante injectada que contiene la ruta
         * donde se encuentra el API de Autores en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function ($scope, $http, tarjetaContext, $state) {
            console.log($state.params);
            if (($state.params.clienteId !== undefined) && ($state.params.clienteId !== null)) {

                var idTarjeta = $state.params.tarjetaId;
                var input = $state.params;
                var params = JSON.stringify(input);


                $http.put(tarjetaContext + '/' + $state.params.clienteId + '/tarjetasCredito/' + idTarjeta, params).then(function (response) {
                    $scope.tarjetasRecords = response.data;
                    console.log(tarjetaContext + '/' + $state.params.clienteId + '/tarjetasCredito/' + idTarjeta);
                    $state.go('tarjetasList', {tarjetaId: response.data.id}, {reload: true});
                });
            }
            ;
        }
    ]);
}
)(window.angular);

