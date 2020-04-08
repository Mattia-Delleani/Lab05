package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;




public class Ricerca {
	
	List<String> soluzione;

	
	public List<String> anagrammi(String parola){
		
		this.soluzione = new ArrayList<String>();
		parola = parola.toLowerCase();
		
		List<Character> disponibili = new ArrayList<Character>();
		
		for(int i=0; i<parola.length();i++) {
			
			disponibili.add(parola.charAt(i));
		}
		
		cerca("", 0, disponibili);
		
		return soluzione;
	}

	private void cerca(String parziale, int livello, List<Character> disponibili) {
		//caso terminale
		if(disponibili.size()==0) {
			//controllo nel database prima di aggiungere alla soluzione
			//if(adao.isCorrect(parziale))
			this.soluzione.add(parziale);
		}
		
	
		for(Character ch: disponibili) {
			
			String tentativo = parziale + ch;
			
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
			
		}
		
		
	}

}
