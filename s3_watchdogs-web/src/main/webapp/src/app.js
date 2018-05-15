(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        //'ui.bootstrap',

        'instalacionesModule',
        'empleadosModule',
        'infosModule',
        'faqsModule',
        'contactanosModule',

        // Internal modules dependencies
        'clientesModule',
        'empleadosAdminModule',
        'serviciosAdminModule',
        'serviciosModule',
        'instalacionesAdminModule',
        //'instalacionesAdminModule',
        'mascotasModule',
        'entrenamientosModule',
        'aseosModule',
        //'servicioModule',
        'loginModule',
        'paseosModule',
        'hotelesModule',
        'rutaModule',
        'metodoDePagoModule',
        'calificacionesModule',
        'facturaModule'


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