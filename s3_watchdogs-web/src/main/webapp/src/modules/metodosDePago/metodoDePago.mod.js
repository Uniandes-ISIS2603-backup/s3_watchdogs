(function (ng) {

    var mod = ng.module("metodoDePagoModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/metodosDePago/';

            $urlRouterProvider.otherwise("/PSEList");

            $stateProvider.state('payPalList', {

                url: '/payPal/list',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'paypal.list.html',
                        controller: 'payPalCtrl'
                    }
                }
            }).state('PSEList', {

                url: '/PSE/list',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'PSE.list.html',
                        controller: 'PSECtrl'
                    }
                }
            }).state('tarjetaList', {

                url: '/tarjeta/list',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'tarjeta.list.html'
                    }
                }
            }).state('metodoDePagoCreate', {

                url: '/metodoDePago/crear',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'MetodoDePago.create.html'
                    }
                }
                
            }).state('payPalCreate', {

                url: '/payPal',
                parent: 'metodoDePagoCreate',
                views: {
                    payPalCreate: {
                        templateUrl: basePath + 'payPal.create.html'
                    }
                }
                
            }).state('temporal', {
                params: {
                    correo: null
                },
                url: '/payPal',
                parent: 'metodoDePagoCreate',
                views: {
                    payPalCreate: {
                        templateUrl: basePath + 'payPal.create.html',
                        controller: 'payPalCreateCtrl'
                    }
                }
            }).state('tarjetaUpdate', {

                url: '/tarjeta/update',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'tarjeta.update.html'
                    }
                }
            })

                    ;


        }]);
})(window.angular);


