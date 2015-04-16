function PertecodeCtrl($filter, $resource) {
	this.self = this;
	
	var askMDP = $resource('/api/disclameLost/:email/:password',
        {
			email: '@email', password: 'password'
		},
        {
            'save': {method:'POST'}
        }
    );
	
	this.askForMDP = function(user) {
		askMDP.save({email: user.email, password: user.password}, function(success){
			console.log(success);
		}, function(error){
			console.log(error);
		});
	};
	/*this.resultUserList = [];

	var users = $resource('/api/users',
        {},
        {
            'get': {method:'GET', isArray:true}
        }
    );
	var userById = $resource('/api/user/:userId',
        {},
        {
            'get': {method:'GET', isArray:false}
        }
    );
	this.resultUserList = users.get(function(result){
		self.resultUserList = result;
		angular.forEach(self.resultUserList, function(user){
			var date = new Date(user.birthday);
			user.birthday = $filter('date')(date, "dd/MM/yyyy 'à' h:mm");
		});
		var a = 2;
	});*/
}
angular
    .module('zingzingApp')
	.controller('PertecodeCtrl', PertecodeCtrl);