(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        //'ui.bootstrap',

        // Internal modules dependencies
        'clientesModule',
        'empleadosAdminModule',
        'serviciosAdminModule',
        'serviciosModule',
        'instalacionesAdminModule',
        //'instalacionesAdminModule',
        'mascotasModule',
        'entrenamientosModule',
        //'servicioModule',
        'loginModule'


    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);

    app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/home/';

            $urlRouterProvider.otherwise("/home");

            $stateProvider.state('home', {

                url: '/home',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'home.main.html'
                    },
                    'userView': {
                        templateUrl: basePath + 'home.login.html',
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl'
                    },
                    'resumeView': {
                        templateUrl: basePath + 'home.resume.html'
                    }
                }
            });
        }]);


})(window.angular);