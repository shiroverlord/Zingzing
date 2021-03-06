package Tools;

import java.util.List;

import model.Historique;
import model.Utilisateur;

import org.json.JSONArray;
import org.json.JSONObject;

import tools.Tools;

public class ConstructJSONObjects {
	
	public static JSONObject getJSONforUser(Utilisateur u) {
		return new JSONObject()
		.put("id", u.getId())
		.put("nom", u.getNom())
		.put("prenom", u.getPrenom());
	}
	
	public static JSONArray getJSONArrayforListUsers(List<Utilisateur> lu) {
		JSONArray ja = new JSONArray();
		for (Utilisateur user : lu) {
			ja.put(getJSONforUser(user));
		}
		return ja;
	}
	
	public static JSONObject getJSONforHistorique(Historique h) {
		return new JSONObject()
		.put("salle", h.getSalle().getLibelle())
		.put("personne", h.getUtilisateur().getFullName())
		.put("date", Tools.formatDateToDisplay(h.getDate()));
	}
	
	public static JSONArray getJSONArrayforListHistoriques(List<Historique> lh) {
		JSONArray ja = new JSONArray();
		for (Historique historique : lh) {
			ja.put(getJSONforHistorique(historique));
		}
		return ja;
	}
}
