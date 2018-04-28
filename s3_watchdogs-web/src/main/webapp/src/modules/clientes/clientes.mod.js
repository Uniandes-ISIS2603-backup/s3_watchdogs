 (function (ng) {
    
    var mod = ng.module("clientesModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/clientes/';
            //var basePathMascotas = "src/modules/mascotas/";
            
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientes', {
                url: '/clientes',
                //abstract: true,
                views: {
                    'completeView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'navView': {
                        templateUrl: basePath + 'clientes.nav.html'
                    }
                }
            }).state('clientesList', {
                url: '/list',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                  clienteId: null  
                },
                views: {
                    'clienteDetailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clientesCreate', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clientesNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clienteUpdate', {
                url: '/{clienteId:int}/update',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'clienteUpdateView': {
                        templateUrl: basePath + '/update/clientes.update.html',
                        controller: 'clienteUpdateCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin', 'assistant']
                }
            }).state('clienteDelete', {
                url: '/delete/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            });
    }]);
})(window.angular);