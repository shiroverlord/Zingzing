'use strict';

// Declare app level module which depends on views, and components
angular.module('libraryApp', [
  'ngRoute',
  'libraryApp.view1',
  'libraryApp.view2',
  'libraryApp.version'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
;angular
    .module('libraryApp')
    .config(function ($stateProvider, $urlRouterProvider) {
        ///////////
        /* VIEWS */
        ///////////
        $stateProvider.state('main', {
            abstract: true,
            sticky: true
        });

        $stateProvider.state('ilot', {
            parent: 'main',
            url: '/ilot?machineIds',
            title: 'Ateliers',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: 'app/ilotSelection/ilotSelection.html',
                    controller: 'IlotSelectionController',
                    controllerAs: 'ilotCtrl',
                    resolve: {
                        ilots : function($q, IlotDataService, IndicatorsDataService) {
                            return IlotDataService.getIlots()
                                .$promise;
                        }
                    }
                }
            }
        });

        ///////////////
        /* OTHERWISE */
        ///////////////
        $urlRouterProvider.otherwise('/404');
    });;'use strict';

angular.module('myApp.version.interpolate-filter', [])

.filter('interpolate', ['version', function(version) {
  return function(text) {
    return String(text).replace(/\%VERSION\%/mg, version);
  };
}]);
;'use strict';

describe('myApp.version module', function() {
  beforeEach(module('myApp.version'));

  describe('interpolate filter', function() {
    beforeEach(module(function($provide) {
      $provide.value('version', 'TEST_VER');
    }));

    it('should replace VERSION', inject(function(interpolateFilter) {
      expect(interpolateFilter('before %VERSION% after')).toEqual('before TEST_VER after');
    }));
  });
});
;'use strict';

angular.module('myApp.version.version-directive', [])

.directive('appVersion', ['version', function(version) {
  return function(scope, elm, attrs) {
    elm.text(version);
  };
}]);
;'use strict';

describe('myApp.version module', function() {
  beforeEach(module('myApp.version'));

  describe('app-version directive', function() {
    it('should print current version', function() {
      module(function($provide) {
        $provide.value('version', 'TEST_VER');
      });
      inject(function($compile, $rootScope) {
        var element = $compile('<span app-version></span>')($rootScope);
        expect(element.text()).toEqual('TEST_VER');
      });
    });
  });
});
;'use strict';

angular.module('myApp.version', [
  'myApp.version.interpolate-filter',
  'myApp.version.version-directive'
])

.value('version', '0.1');
;'use strict';

describe('myApp.version module', function() {
  beforeEach(module('myApp.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
;'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', [function() {

}]);;'use strict';

describe('myApp.view1 module', function() {

  beforeEach(module('myApp.view1'));

  describe('view1 controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var view1Ctrl = $controller('View1Ctrl');
      expect(view1Ctrl).toBeDefined();
    }));

  });
});;'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', [function() {

}]);;'use strict';

describe('myApp.view2 module', function() {

  beforeEach(module('myApp.view2'));

  describe('view2 controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var view2Ctrl = $controller('View2Ctrl');
      expect(view2Ctrl).toBeDefined();
    }));

  });
});