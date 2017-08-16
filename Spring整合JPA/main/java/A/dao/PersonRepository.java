package A.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import A.entities.Person;

@org.springframework.stereotype.Repository
public interface PersonRepository extends Repository<Person , Integer>{
	List<Person> getByName(String name);
	List<Person> getByNameStartingWith(String name);
	List<Person> getByIdLessThanAndNameEndsWith(Integer id,String name);
	List<Person> getByNameIn(List<String> list);
	List<Person> getByNameLike(String name);
	
	/*
	 * ºÜºÃÍæ
	 */
	@Query("from Person p1 where p1.id = (select max(p2.id) from Person p2)")
	List<Person> getoo();
	@Query("from Person p where name like ?1 and id > ?2")
	List<Person> ooo(String name , Integer id);
	@Query(value="select * from Person where id > ? order by id desc",nativeQuery=true)
	List<Person> ooo2(Integer id);	
	
	@Modifying
	@Query(value="update Person p set p.name = :name where p.id = :id")
	void ooo3(@Param("id")Integer id , @Param("name")String name);
}
