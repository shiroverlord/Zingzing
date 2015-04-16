function zingzingNavbarTop(){
    return{
        restrict:'E',
        templateUrl:'/directives/zingzingNavbarTop.html',
        controller: zingzingNavbarTopController,
        controllerAs: 'navbarTopCtrl'
    };
}
function zingzingNavbarTopController() {
	var self = this;
	
}
angular
    .module('zingzingApp')
    .directive('zingzingNavbarTop',zingzingNavbarTop);