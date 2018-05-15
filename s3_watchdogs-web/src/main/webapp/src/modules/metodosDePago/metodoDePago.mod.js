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
            }).state('tarjetasList', {

                url: '/tarjetas/list',
                parent: 'clienteDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'tarjetas.list.html',
                        controller: 'tarjetasCtrl'
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
            }).state('payPalCreate', {

                url: '/payPal',
                parent: 'clienteDetail',
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
                parent: 'clienteDetail',
                views: {
                    payPalCreate: {
                        templateUrl: basePath + 'payPal.create.html',
                        controller: 'payPalCreateCtrl'
                    }
                }
            }).state('PSECreate', {

                url: '/PSE/create',
                parent: 'clienteDetail',
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
                parent: 'clienteDetail',
                views: {
                    PSECreate: {
                        templateUrl: basePath + 'PSE.create.html',
                        controller: 'PSECreateCtrl'
                    }
                }
            }).state('temporal', {
                url: '/detail',
//                param: {
//                  clienteId: null  
//                },
                views: {
                    clienteDetailMetodoDePago: {
                        templateUrl: basePath + 'cliente.detail.metodoDePago.html'
                    }
                }
            }).state('tarjetaCreate', {

                url: '/tarjeta/create',
                parent: 'clienteDetail',
                views: {
                    tarjetaCreate: {
                        templateUrl: basePath + 'tarjetas.create.html'
                    }
                }
            }).state('temporalCrearTarjeta', {

                params: {
                    numeroTarjeta: null,
                    fechaVencimiento: null,
                    codigoSeguridad: null
                },

                url: '/tarjeta/create',
                parent: 'clienteDetail',
                views: {
                    tarjetaCreate: {
                        templateUrl: basePath + 'tarjetas.create.html',
                        controller: 'tarjetaCreateCtrl'
                    }
                }
            }).state('deleteTarjeta', {
                params: {
                    tarjetaId: null
                },

                url: 'tarjeta/delete/{tarjetaId:int}',
                parent: 'clienteDetail',
                views: {
                    tarjetaDelete: {
                        templateUrl: basePath + 'tarjeta.delete.html',
                        controller: 'tarjetaDeleteCtrl'
                    }
                }
            }).state('deletePayPal', {
                params: {
                    payPalId: null
                },

                url: '/delete/{payPalId:int}',
                parent: 'clienteDetail',
                views: {
                    payPalDelete: {
                        templateUrl: basePath + 'payPal.delete.html',
                        controller: 'payPalDeleteCtrl'
                    }
                }
            }).state('tarjetaUpdate', {
                params: {
                    tarjetaId: null
                },

                url: '/tarjeta/{tarjetaId:int}/update',
                parent: 'clienteDetail',
                views: {
                    tarjetaUpdate: {
                        templateUrl: basePath + 'tarjetas.update.html'
                    }
                }
            }).state('temporalUpdateTarjeta', {
                params: {

                    numeroTarjeta: null,
                    fechaVencimiento: null,
                    codigoSeguridad: null
                },
                url: 'prueba',
                parent: 'tarjetaUpdate',
                views: {
                    update: {
                        controller: 'tarjetaUpdateCtrl'
                    }
                }
            }).state('deletePSE', {
                params: {
                    PSEId: null
                },

                url: '/delete/{PSEId:int}',
                parent: 'clienteDetail',
                views: {
                    PSEDelete: {
                        templateUrl: basePath + 'PSE.delete.html',
                        controller: 'PSEDeleteCtrl'
                    }
                }
            }).state('payPalUpdate', {
                params: {
                    payPalId: null
                },

                url: '/payPal/{payPalId:int}/update',
                parent: 'clienteDetail',
                views: {
                    payPalUpdate: {
                        templateUrl: basePath + 'payPal.update.html'
                    }
                }
            }).state('temporalUpdatePayPal', {
                params: {

                    correo: null
                },
                url: 'prueba',
                parent: 'payPalUpdate',
                views: {
                    updatePayPal: {
                        controller: 'payPalUpdateCtrl'
                    }
                }
            }).state('PSEUpdate', {
                params: {
                    PSEId: null
                },

                url: '/PSE/{PSEId:int}/update',
                parent: 'clienteDetail',
                views: {
                    payPalUpdate: {
                        templateUrl: basePath + 'PSE.update.html'
                    }
                }
            }).state('temporalUpdatePSE', {
                params: {

                    correo: null
                },
                url: 'prueba',
                parent: 'PSEUpdate',
                views: {
                    updatePSE: {
                        controller: 'PSEUpdateCtrl'
                    }
                }
            })

                    ;


        }]);
})(window.angular);


