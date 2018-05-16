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

    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin;
                var roles = $state.current.data.roles;
               

                /**
                 * @ngdoc function
                 * @name isAuthenticated
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario se encuentra
                 * dentro de su cuenta.
                 * @returns {Boolean} Verdadero si está dentro de su cuenta.
                 */
                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("username") !== null) {
                        $rootScope.currentUser = sessionStorage.getItem("name");
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
                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
                        return true;
                    } else {
                        return false;
                    }
                };
                
                $rootScope.esCliente = function () {
                    $rootScope.cliente = true;
                    $rootScope.admin = false;
                    $rootScope.empleado = false;
                };
                $rootScope.esAdmin=function () {
                    $rootScope.admin = true;
                    $rootScope.empleado = false;
                    $rootScope.cliente = false;
                    
                };
                $rootScope.esEmpleado = function () {
                    $rootScope.empleado = true;
                    $rootScope.cliente = false;
                    $rootScope.admin = false;
                };

                if (requireLogin && (sessionStorage.getItem("username") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });
        }]);


})(window.angular);