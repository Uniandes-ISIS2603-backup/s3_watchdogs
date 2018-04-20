(function (ng) {

    var mod = ng.module("payPalModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/payPal/';

            $urlRouterProvider.otherwise("/payPalList");

            $stateProvider.state('payPalList', {

                url: '/payPal/list',
                parent: 'perfilShow',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'paypal.list.html',
                        
                    }
                }
            });


        }]);
})(window.angular);


