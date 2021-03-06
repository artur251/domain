package com.asseco.repository;

import java.util.Collection;

/**
 * Repozytorium zarzadzajace encjami osoby
 *
 * TODO Metody nalezy zaimplementowac mozliwie optymalnie aby wywolania miescily sie w czasach okreslonych w tescie
 */
public interface PersonRepositoryInterface {

	/**
	 * Pobiera caly zbior zapisanych encji
	 * @return
	 */
	Collection<PersonInterface> findAll();
	
	/**
	 * Wyszukuje encje na podstawie przekazanego id
	 * @param id
	 * @return
	 */
	PersonInterface findOne(long id) throws PersonNotFoundException;
	
	/**
	 * Dodaje osobe
	 * 
	 * @param person
	 * @return zapisana encja z uzupelnionym numerem ID
	 */
	PersonInterface save(PersonInterface person);
	
	/**
	 * Aktualizuje osobe
	 * 
	 * @param person
	 * @return zapisana encja
	 */
	PersonInterface update(PersonInterface person);
	
	/**
	 * Wyszukuje osoby spelniajace zadane kryteria
	 * @param name imie, nie moze byc null
	 * @param surname nazwisko, nie moze byc null
	 * @return zbior osob spelniajacych kryteria
	 */
	Collection<PersonInterface> findByNameAndSurname(String name, String surname);
	
	/**
	 * Pobiera zbior osob spelniajacych kryteria posortowany wg. nazwiska 
	 * @param fromSurname 	od jakiego naywiska maja byc zwracane dane (wlacznie z podanym). 
	 * 						Dla wartosci null zwracany jest zbior od poczatku
	 * @param endSurname 	do jakiego nazwiska maja byc zwracane dane (wlacznie z podanym).
	 * 						Dla wartosci null zwracany jest zbior do konca kolekcji.
	 * @return zbior osob posortowany po nazwisku
	 */
	Collection<PersonInterface> findBySurnameBetweenOrderBySurname(String fromSurname, String endSurname);
	
	
	/**
	 * Nie znaleziono szukanej osoby
	 */
	static class PersonNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
	
}
