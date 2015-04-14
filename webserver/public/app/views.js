angular
    .module('libraryApp')
    .config(function ($stateProvider, $urlRouterProvider) {
        ///////////
        /* VIEWS */
        ///////////
        $stateProvider.state('main', {
            abstract: true,
            sticky: true
        });

        $stateProvider.state('home', {
            parent: 'main',
            url: '/home',
            title: 'Home',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: '/home/home.html',
                    controller: 'HomeCtrl',
                    controllerAs: 'HomeCtrl'
                }
            }
        });
		
		$stateProvider.state('books', {
            parent: 'main',
            url: '/books',
            title: 'Books',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: '/books/books.html',
                    controller: 'BooksCtrl',
                    controllerAs: 'BooksCtrl'
                }
            }
        });
		
		$stateProvider.state('book', {
            parent: 'books',
            url: '/{bookId:int}',
            title: 'Book',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: '/book/book.html',
                    controller: 'BookCtrl',
                    controllerAs: 'BookCtrl'
                }
            }
        });
		
		$stateProvider.state('contacts', {
            parent: 'main',
            url: '/contacts',
            title: 'Contacts',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: '/contacts/contacts.html',
                    controller: 'ContactsCtrl',
                    controllerAs: 'ContactsCtrl'
                }
            }
        });

        $stateProvider.state('developpeur', {
            parent: 'main',
            url: '/developpeur',
            title: 'Developpeur',
            reloadOnSearch: false,
            views: {
                'main@': {
                    templateUrl: '/developpeur/developpeur.html',
                    controller: 'DeveloppeurCtrl',
                    controllerAs: 'DeveloppeurCtrl'
                }
            }
        });

        ///////////////
        /* OTHERWISE */
        ///////////////
        //TODO 404
        $urlRouterProvider.otherwise('/home');
    });