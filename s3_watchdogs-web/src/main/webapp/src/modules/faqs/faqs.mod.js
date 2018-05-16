(function (ng) {
    
    var mod = ng.module("faqsModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/faqs/';
            
            $urlRouterProvider.otherwise("/faqsList");
            
            $stateProvider.state('faqsList', {
                
                url: '/faqs/list',
                views: {
                    'completeView': {
                        templateUrl: basePath + 'faqs.list.html'
                        
                    }
                }
            });
    }]);
})(window.angular);

