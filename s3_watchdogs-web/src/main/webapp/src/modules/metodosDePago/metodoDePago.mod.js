(function (ng) {

    var mod = ng.module("metodoDePagoModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/metodosDePago/';

            $urlRouterProvider.otherwise("/PSEList");

            $stateProvider.state('payPalList', {

                url: 'payPal/list',
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

            }).state('temporalCrearPayPal', {
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
            }).state('PSECreate', {

                url: '/PSE/create',
                parent: 'metodoDePagoCreate',
                views: {
                    PSECreate: {
                        templateUrl: basePath + 'PSE.create.html'
                    }
                }
            }).state('temporalCrearPSE', {
                
                 params: {
                    correo: null
                },

                url: '/PSE/create',
                parent: 'metodoDePagoCreate',
                views: {
                    PSECreate: {
                        templateUrl: basePath + 'PSE.create.html',
                        controller: 'PSECreateCtrl'
                    }
                }
            })

                    ;


        }]);
})(window.angular);


