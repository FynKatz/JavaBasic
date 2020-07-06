package com.huyy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.huyy.dao.UsersDao;
import com.huyy.pojo.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;//在配置文件中有加载实例对象

	@Override
	public void insertUsers(Users users) {
		this.hibernateTemplate.save(users);
	}
	@Override
	public void updateUsers(Users users) {
		this.hibernateTemplate.update(users);
	}
	@Override
	public void deleteUsers(Users users) {
		this.hibernateTemplate.delete(users);
	}
	@Override
	public Users selectUsersById(Integer userid) {
		return this.hibernateTemplate.get(Users.class, userid);
	}
	
	@Override
	public List<Users> selectUserByName(String username) {
		/*1.先获取session对象
		 * 说明：getCurrentSession:当前session 必须要有事务边界，且只能处理唯一的一个事务。当事务提交或者回滚后session自动失效。
		openSession:每次都会打开一个新的session,获得的是不同session对象。使用完毕后需要手动调用colse 方法关闭session*/
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();// import org.hibernate.Session;

		/*2.写HQL查询语句
		 * 模仿SQL语句:select * from t_users where username = ?
		 * 将原来的SQL 语句中的表与字段名称换成对象与属性的名称*/
		Query query = session.createQuery("from Users where username = :abc");// import org.hibernate.Query;
		Query queryTemp = query.setString("abc", username);
		return queryTemp.list();
	}
	
	@Override
	public List<Users> selectUserByNameUseSQL(String username) {
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery("select * from t_users	where username = ?")
				.addEntity(Users.class).setString(0, username);
		return query.list();
	}
	
	@Override
	public List<Users> selectUserByNameUseCriteria(String username) {
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		// sql:select * from t_users where username = 张三
		Criteria c = session.createCriteria(Users.class);
		c.add(Restrictions.eq("username", username));
		return c.list();
	}
}
