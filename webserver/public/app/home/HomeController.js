function HomeCtrl($resource) {
	this.self = this;
	this.resultTestString = {};
	this.resultTestRMIString = {};

	var testString = $resource('/api/test/string',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	var testStringFromRMI = $resource('/api/testRMI/string',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	this.resultTestString = testString.get();
	this.resultTestRMIString = testStringFromRMI.get();
}
angular
    .module('libraryApp')
	.controller('HomeCtrl', HomeCtrl);