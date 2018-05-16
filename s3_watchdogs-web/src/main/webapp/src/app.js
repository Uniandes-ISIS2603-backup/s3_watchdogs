/**
 * @ngdoc overview
 * @name mainApp.module:mainApp
 * @description
 * Definicion del modulo principal de Angular. El modulo encapsula todos los modulos de la aplicacion incluyendo los
 * modulos externos que son injectados dentro de otros modulos (como Bootstrap y el Router). Este modulo inicia la
 * aplicacion al momento de ingresar a cualquier pagina de ka aokicacion por primera vez.
 * @param {type} ng
 * @returns {undefined}
 */
(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',

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
        'mascotasModule',
        'entrenamientosModule',
        'aseosModule',
        'loginModule',
        'paseosModule',
        'hotelesModule',
        'rutaModule',
        'metodoDePagoModule',
        'calificacionesModule',
        'facturaModule',
        'disponibilidadModule',
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
                    'navView': {
                       templateUrl: basePath + 'home.nav.html'
                    },
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

    app.run(['$rootScope', "$state", function ($rootScope, $state) {

            /**
             * @ngdoc function
             * @name isAuthenticated
             * @methodOf mainApp.module:mainApp
             * @description Esta función define si el usuario se encuentra
             * dentro de su cuenta.
             * @returns {Boolean} Verdadero si está dentro de su cuenta.
             */
            $rootScope.isAuthenticated = function () {
                if (sessionStorage.getItem("username") === "null" || sessionStorage.getItem("id") === null) {
                    return false;
                } else {
                    return true;
                }
            };

            /**
             * @ngdoc function
             * @name hasPermissions
             * @methodOf mainApp.module:mainApp
             * @description Esta función define si el usuario tiene permisos
             * para acceder a la aplicación.
             * @returns {Boolean} Verdadero si el usuario tiene permisos.
             */
            $rootScope.hasPermissions = function () {
                if (($rootScope.isAuthenticated) && (sessionStorage.getItem("rol") === "admin" || sessionStorage.getItem("rol") === "assistant")) {
                    return true;
                } else {
                    return false;
                }
            };
            /**
             * @ngdoc function
             * @name hasPermissions
             * @methodOf mainApp.module:mainApp
             * @description Esta función define si el usuario tiene permisos
             * para acceder a la aplicación.
             * @returns {Boolean} Verdadero si el usuario tiene permisos.
             */
            $rootScope.isAdmin = function () {
                if (($rootScope.isAuthenticated) && (sessionStorage.getItem("rol") === "admin")) {
                    return true;
                } else {
                    return false;
                }
            };
            $rootScope.logOut = function ()
            {
                sessionStorage.token = null;
                sessionStorage.setItem("username", null);
                sessionStorage.setItem("rol", null);
                sessionStorage.setItem("id", null);
                sessionStorage.setItem("name", null);
                alert('Se ha cerrado correctamente la sesión');
            };
        }]);
})(window.angular);