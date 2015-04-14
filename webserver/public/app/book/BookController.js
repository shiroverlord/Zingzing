function BookCtrl($resource, $stateParams) {
	this.self = this;
	this.resultBook = {};

	var bookById = $resource('/api/book/:bookId',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	
	this.resultBook = bookById.get({bookId: $stateParams.bookId});
}
angular
    .module('libraryApp')
	.controller('BookCtrl', BookCtrl);