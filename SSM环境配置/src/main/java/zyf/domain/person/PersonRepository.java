package zyf.domain.person;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* @author 庄元丰
*/
@Repository
public class PersonRepository extends SqlSessionDaoSupport {
	private static final String NAME_SPACE = "A.AA.TestMapper";
	
	@Autowired
    public void setSqlSessionFactory(SqlSessionFactory enterpriseSqlSessionFactory) {
        super.setSqlSessionFactory(enterpriseSqlSessionFactory);
    }
	
	public Person query() {
		return getSqlSession().selectOne(NAME_SPACE + ".selectPerson" , 1);
	}
}
