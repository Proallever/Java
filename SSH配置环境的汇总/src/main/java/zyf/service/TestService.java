package zyf.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import zyf.domain.Student.Student;

@Service
public class TestService {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Cacheable(value="students")
	public Student getStudent(long id){
		System.out.println("00000000");
		return manager.find(Student.class, id);
	}
	
}
