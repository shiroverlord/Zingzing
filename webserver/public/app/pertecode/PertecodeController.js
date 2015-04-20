function PertecodeCtrl($filter, $http) {
	var self = this;
	this.envoiePerteCode = false;
	this.envoiePerteCodeSuccess = false;
	this.envoiePerteCodeFailed = false;
	
	/*var askMDP = $resource('/api/disclameLost/:email/:password',
        {
			email: '@email', password: 'password'
		},
        {
            'save': {method:'POST'}
        }
    );*/
	
	this.askForMDP = function(user) {
		self.envoiePerteCode = true;
		/*askMDP.save({email: user.email, password: user.password}, function(success){
			self.envoiePerteCodeSuccess = true;
			self.envoiePerteCodeFailed = false;
		}, function(error){
			self.envoiePerteCodeSuccess = false;
			self.envoiePerteCodeFailed = true;
		});*/
		
		$http.post('/api/disclameLost/' + user.email, {password: user.password})
            .success(function(data, status, headers, config) {
				self.envoiePerteCodeSuccess = true;
				self.envoiePerteCodeFailed = false;
                /*self.isConnectedStatus = true;
                ipCookie('nom', data.user.nom, {expires : 365});
                ipCookie('id', data.user.id, {expires : 365});
                ipCookie('role', data.user.role, {expires : 365});
                ipCookie('token', data.user.token, {expires : 365});
                ConfigurationService.extendConfiguration(data);
                $rootScope.$broadcast('config.loaded');
                success(data, status, headers, config);*/
            })
            .error(function(error){
				self.envoiePerteCodeSuccess = false;
				self.envoiePerteCodeFailed = true;
			});
		
	};
}
angular
    .module('zingzingApp')
	.controller('PertecodeCtrl', PertecodeCtrl);