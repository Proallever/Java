package A.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import A.entities.Person;

public interface PersonRepository3 extends PagingAndSortingRepository<Person, Integer>{

}
