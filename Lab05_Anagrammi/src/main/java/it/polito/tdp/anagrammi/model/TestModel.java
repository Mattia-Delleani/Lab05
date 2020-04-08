package it.polito.tdp.anagrammi.model;

import java.util.List;


public class TestModel {

	public static void main(String[] args) {
		Ricerca ric = new Ricerca() ;
		
		List<String> ana_dog = ric.anagrammi("eat") ;
		System.out.println(ana_dog.toString()+"\n") ;
		System.out.println();

	}
}
