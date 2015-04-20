function HomeCtrl($resource) {
	this.self = this;
	this.resultTestString = {};
	this.resultTestRMIString = {};

	/*var testString = $resource('/api/test/string',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	this.resultTestString = testString.get();*/
}
angular
    .module('zingzingApp')
	.controller('HomeCtrl', HomeCtrl);