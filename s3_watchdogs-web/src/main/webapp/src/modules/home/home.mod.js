
(function (ng) {
    // Definición del módulo
    var mod = ng.module("loginModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

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
        }
    ]);
})(window.angular);

