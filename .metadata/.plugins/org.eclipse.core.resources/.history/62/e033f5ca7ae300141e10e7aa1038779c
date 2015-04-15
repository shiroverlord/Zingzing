package Tools;

import java.util.List;

import model.Utilisateur;

import org.json.JSONArray;
import org.json.JSONObject;

import tools.Tools;

public class ConstructJSONObjects {
	
	public static JSONObject getJSONforUser(Utilisateur u) {
		return new JSONObject()
		.put("id", u.getId())
		.put("lastname", u.getNom())
		.put("firstname", u.getPrenom())
		.put("birthday", Tools.formatDateToDisplay(u.getDateNaissance()));
	}
	
	public static JSONArray getJSONArrayforListUsers(List<Utilisateur> lu) {
		JSONArray ja = new JSONArray();
		for (Utilisateur user : lu) {
			ja.put(getJSONforUser(user));
		}
		return ja;
	}
}
