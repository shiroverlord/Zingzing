function ncisNavbarTop(){
    return{
        restrict:'E',
        templateUrl:'/directives/ncisNavbarTop.html',
        controller: ncisNavbarTopController,
        controllerAs: 'navbarTopCtrl'
    };
}
function ncisNavbarTopController() {
	var self = this;
	
}
angular
    .module('libraryApp')
    .directive('ncisNavbarTop',ncisNavbarTop);