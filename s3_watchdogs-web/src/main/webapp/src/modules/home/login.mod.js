
(function (ng) {
    // Definición del módulo
    var mod = ng.module("loginModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/home/';

            $urlRouterProvider.otherwise("/login");


            $stateProvider.state('login', {
                url: '/login',
                data: {
                    requireLogin: false
                },
                views: {
                    'userView': {
                        templateUrl: basePath + 'home.login.html',
                        controller: 'loginCtrl'
                    }
                }
            }).state('logout', {
                url: '/logout',
                data: {
                    requireLogin: false,
                    roles: []
                }
                ,
                views: {
                    'userView': {
                        templateUrl: basePath + 'home.logout.html',
                        controller: 'logoutCtrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

