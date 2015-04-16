function HistoriqueCtrl($filter, $resource) {
	this.self = this;
	
	this.resultList = [];
	//this.resultList.push({salle:'Fab Lab', personne:'Saint-Jean Pierrick', date:'16/04/2015 16:11'});
	
	var historiques = $resource('/api/historiques',
        {},
        {
            'get': {method:'GET', isArray:true}
        }
    );
	
	this.resultList = historiques.get(function(result){
		self.resultList = result;
		angular.forEach(self.resultList, function(historique){
			var date = new Date(historique.date);
			historique.date = $filter('date')(date, "dd/MM/yyyy 'à' H:mm");
		});
	});

	/*var users = $resource('/api/users',
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
	});*/
}
angular
    .module('zingzingApp')
	.controller('HistoriqueCtrl', HistoriqueCtrl);