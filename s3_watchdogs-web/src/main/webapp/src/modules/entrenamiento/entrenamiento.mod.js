/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("entrenamientoModule", ['ui.router']);
    mod.constant("entrenamientosContext", "api/entrenamientos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/entrenamientos/';
            var basePathBooks = 'src/modules/books/';
            $urlRouterProvider.otherwise("/entrenamientosList");
            $stateProvider.state('entrenamientos', {
                url: '/entrenamientos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'entrenamientos.html',
                        controller: 'entrenamientoCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            }).state('entrenamientosList', {
                url: '/list',
                parent: 'entrenamientos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'entrenamientos.terminado.html'
                    }
                }
            }).state('entrenamientoDetail', {
                url: '/{entrenamientoId:int}/detail',
                parent: 'entrenamientos',
                param: {
                    entrenamientoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'entrenamientos.view.html',
                        controller: 'entrenamientoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
