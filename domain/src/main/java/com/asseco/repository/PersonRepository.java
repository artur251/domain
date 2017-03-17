package com.asseco.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

//import com.asseco.repository.PersonRepository.PersonNotFoundException;
import com.asseco.repository.PersonRepositoryInterface.PersonNotFoundException;

public class PersonRepository implements PersonRepositoryInterface {

	public ArrayList<PersonInterface> collectionPersonsArrayList;
	public SortedSet<PersonInterface> collectionPersonsSortedSet;
	public Map<Long, PersonInterface> collectionPersonsMap;

	public PersonRepository() {
		// r�ne struktury repozytorium Person do r�nych metod wydajnego
		// wyszukiwania
		this.collectionPersonsArrayList = new ArrayList<PersonInterface>();
		this.collectionPersonsSortedSet = new TreeSet<PersonInterface>();
		this.collectionPersonsMap = new HashMap<Long, PersonInterface>();
	}

	@Override
	public Collection<PersonInterface> findAll() {
		Collection<PersonInterface> persons = new ArrayList<PersonInterface>(collectionPersonsArrayList);
		return persons;
		// return collectionPersonsArrayList;
	}

	@Override
	public PersonInterface findOne(long id) throws PersonNotFoundException {

		// dzia�a ale s�abe
		// -1 bo numeracja w tablicy od 0
		// return collectionPersonsArrayList.get((int) id - 1);

		// wersja niezale�na od organizacji pozycji w kolekcji
		for (PersonInterface pi : collectionPersonsArrayList) {
			if (pi.getId() == (int) id) {
				return pi;
			}
		}
		throw new PersonNotFoundException();
	}

	@Override
	public PersonInterface save(PersonInterface person) {
		collectionPersonsArrayList.add(person);
		collectionPersonsSortedSet.add(person);
		collectionPersonsMap.put(person.getId(), person);
		return person;
	}

	@Override
	public PersonInterface update(PersonInterface person) {
		collectionPersonsArrayList.remove(findOne(person.getId()));
		collectionPersonsArrayList.add(person.getId().intValue() - 1, person);
		return person;
	}

	@Override
	public Collection<PersonInterface> findByNameAndSurname(String name, String surname) {

		// System.out.println("findByNameAndSurname
		// collectionPersons.size()="+collectionPersons.size());
		Collection<PersonInterface> result = new ArrayList<PersonInterface>();
		for (PersonInterface person : collectionPersonsArrayList) {
			if (name.equals(person.getName()) && surname.equals(person.getSurname()))
				result.add(person);
		}
		// System.out.println("findByNameAndSurname
		// result.size()="+result.size());
		return result;
	}

	@Override
	public Collection<PersonInterface> findBySurnameBetweenOrderBySurname(String fromSurname, String endSurname) {
		// TODO Auto-generated method stub
		Collection<PersonInterface> result = new ArrayList<PersonInterface>();
		for (PersonInterface person : collectionPersonsArrayList) {
			if (fromSurname.equals(person.getName()) && endSurname.equals(person.getSurname()))
				result.add(person);
		}
		return result;
	}

	@Override
	public String toString() {
		return "PersonRepository [collectionPersonsArrayList=" + collectionPersonsArrayList
				+ ", collectionPersonsSortedSet=" + collectionPersonsSortedSet + ", collectionPersonsMap="
				+ collectionPersonsMap + "]";
	}

	public String sizes() {
		return "PersonRepository sizes " + "[" + "  collectionPersonsArrayList.size()="
				+ collectionPersonsArrayList.size() + ", collectionPersonsSortedSet.size()="
				+ collectionPersonsSortedSet.size() + ", collectionPersonsMap.size()=" + collectionPersonsMap.size()
				+ "]";
	}

}
