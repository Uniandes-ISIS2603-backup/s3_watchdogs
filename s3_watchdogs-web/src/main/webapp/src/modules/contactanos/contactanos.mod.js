/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    
    var mod = ng.module("contactanosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/contactanos/';
            
            $urlRouterProvider.otherwise("/contactanosList");
            
            $stateProvider.state('contactanosList', {
                
                url: '/contactanos/list',
                views: {
                    'navView': {
                        templateUrl: basePath + 'contactanos.nav.html'
                    },
                    'completeView': {
                        templateUrl: basePath + 'contactanos.list.html'
                        
                    }
                }
            });
    }]);
})(window.angular);

