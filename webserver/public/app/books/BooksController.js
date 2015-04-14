function BooksCtrl($resource) {
	this.self = this;
	this.resultBook = {};

	var bookById = $resource('/api/book/:bookId',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	
	this.resultBook = bookById.get({bookId: '1'});
}
angular
    .module('libraryApp')
	.controller('BooksCtrl', BooksCtrl);