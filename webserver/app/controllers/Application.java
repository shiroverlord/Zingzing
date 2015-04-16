package controllers;

import java.util.List;

import model.Utilisateur;

//import org.json.JSONArray;
import org.json.JSONObject;

import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import rmi.ClientSingleton;
import Tools.ConstructJSONObjects;

public class Application extends Controller {

	public static ClientSingleton clientRMI = ClientSingleton.getInstance();
	
	/*public static Result index() {
		//ok(index.render("Your new application is ready."))
		return redirect("/views/index.html");
	}*/
	public static Promise<Result> getStringTest() {
		Promise<String> promise = Promise.promise(() -> 
		{
			/*JSONObject jo = new JSONObject();
			jo.put("test", clientRMI.getTestString());
			return jo.toString(); */
			return "testString from Play";
		});
		Promise<Result> promiseOfResult = promise.map(result -> {
			return ok(new JSONObject().put("value", result).toString());
		});
		/*Promise<Result> promiseOfResult = promise.map(data ->
		{
			return ok(data);
		});*/
		return promiseOfResult;
	}
	
	/*public static Promise<Result> getBookById(Integer bookId) {
		Promise<String> promise = Promise.promise(() -> 
		{
			JSONObject jo = new JSONObject();
			jo.put("id", bookId)
			.put("libelle", "testLibelle")
			.put("year", "2002");
			return jo.toString(); 
		});
		Promise<Result> promiseOfResult = promise.map(result -> {
			return ok(result);
		});
		return promiseOfResult;
	}
	
	public static Promise<Result> getUserById(Long userId) {
		Promise<String> promise = Promise.promise(() -> 
		{
			Utilisateur u = clientRMI.getUserById(userId);
			if(u != null){
				return ConstructJSONObjects.getJSONforUser(u).toString();
			} else {
				return null;
			}
		});
		Promise<Result> promiseOfResult = promise.map(result -> {
			if(result != null) {
				return ok(result);
			} else {
				return notFound();
			}
		});
		return promiseOfResult;
	}
	
	public static Promise<Result> getAllUsers() {
		Promise<String> promise = Promise.promise(() -> 
		{
			List<Utilisateur> lu = clientRMI.getAllUsers();
			if(lu != null && !lu.isEmpty()){
				return ConstructJSONObjects.getJSONArrayforListUsers(lu).toString();
			} else {
				return null;
			}
		});
		Promise<Result> promiseOfResult = promise.map(result -> {
			if(result != null) {
				return ok(result);
			} else {
				return notFound();
			}
		});
		return promiseOfResult;
	}*/
}
