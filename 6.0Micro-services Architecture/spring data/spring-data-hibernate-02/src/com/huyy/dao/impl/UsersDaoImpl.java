package com.huyy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.huyy.dao.UsersDao;
import com.huyy.pojo.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	//不能用@Autowired,没有在配置文件中加载该实例，这里用工厂模式如下。
	@PersistenceContext(name = "entityManagerFactory")
	private EntityManager entityManager;

	@Override
	public void insertUsers(Users users) {
		this.entityManager.persist(users);
	}

	@Override
	public void updateUsers(Users users) {
		this.entityManager.merge(users);
	}

	@Override
	public void deleteUsers(Users users) {
		Users u = this.selectUsersById(users.getUserid());
		this.entityManager.remove(u);
	}

	@Override
	public Users selectUsersById(Integer userid) {
		return this.entityManager.find(Users.class, userid);
	}

	@Override
	public List<Users> selectUserByName(String username) {
		return this.entityManager.createQuery(" from Users where username = :abc").setParameter("abc", username)
				.getResultList();
	}

	@Override
	public List<Users> selectUserByNameUseSQL(String username) {
		// 在Hibernate JPA 中如果通过？方式来帮顶参数，那么他的查数是从1开始的。而hibernate 中是从0 开始的。
		return this.entityManager.createNativeQuery("select * from t_users where username = ?", Users.class)
				.setParameter(1, username).getResultList();
	}

	@Override
	public List<Users> selectUserByNameUseCriteria(String username) {
		//1.CriteriaBuilder 对象：创建一个CriteriaQuery,创建查询条件。
		CriteriaBuilder builber = this.entityManager.getCriteriaBuilder();
		
		//2.CriteriaQuery 对象：执行查询的Criteria 对象
		CriteriaQuery<Users> query = builber.createQuery(Users.class);
		
		//3.获取要查询的实体类的对象
		Root<Users> root = query.from(Users.class);
		
		//4.封装查询条件
		Predicate cate = builber.equal(root.get("username"), username);
		query.where(cate);
		
		//5.执行查询
		TypedQuery<Users> typeQuery = this.entityManager.createQuery(query);
		return typeQuery.getResultList();
	}
}






