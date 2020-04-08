package it.polito.tdp.anagrammi.model;


import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
	
	private Ricerca ricerca;
	private AnagrammaDAO adao;
	private Set<String> sbagliati;
	
	public Model() {
		
		ricerca = new Ricerca();
		this.adao = new AnagrammaDAO();
		sbagliati = new HashSet<>();
		
	}
	/**
	 * Costruisce gli anagrammi dela parola data
	 * @param parola da anagrammare
	 * @return Lista di tutti gli anagrammi
	 */
	public List<String> getAnagrammi(String parola){
		return ricerca.anagrammi(parola); 
	}
	/**
	 * Ritorna gli anagrammi corretti, popolando anche l'insieme {@code sbagliati} di tipo {@link HashSet}.
	 * Utilizzo {@code HashSet} in quanto la rimozione è immediata.
	 * @param parola parola da anagrammare
	 * @return Lista di anagrammi corretti.
	 */
	public List<String> getAnagrammiCorretti(String parola){
		
		sbagliati.clear();
		List<String> corretti = new ArrayList<>();
		List<String> anagrammi = new ArrayList<>(ricerca.anagrammi(parola));
		sbagliati.addAll(anagrammi);
		for(String tempS: anagrammi) {
			if(adao.isCorrect(tempS)) {
				corretti.add(tempS);
				sbagliati.remove(tempS);

			}
		}
		return corretti;
	}
/**
 * 
 * @return Set di anagrammi non presenti nel dizionario
 */
	public Set<String> getSbagliati() {
		return sbagliati;
	}


	
	
	//con un altro metodo
	/*
	public Set<String> getAnagrammiSbagliati(String parola){
		
		Set<String> sbagliati = new HashSet<>();
		
		for(String tempS: ricerca.anagrammi(parola)) {
			if(!adao.isCorrect(tempS)) {
				sbagliati.add(tempS);
			}
		}
		return sbagliati;
	}
	*/

}
