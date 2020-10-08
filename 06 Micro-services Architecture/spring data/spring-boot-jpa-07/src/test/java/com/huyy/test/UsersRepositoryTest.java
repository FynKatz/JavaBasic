package com.huyy.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.dao.UsersRepositorySpecification;
import com.huyy.pojo.Users;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepositorySpecification usersRepositorySpecification;
	
	/**
	 * JpaSpecificationExecutor   单条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor1() {
		/*Specification<Users>:用于封装查询条件*/
		Specification<Users> spec = new Specification<Users>() {
			/**Predicate:封装了 单个的查询条件
			 * Root<Users> root:查询对象的属性的封装。
			 * CriteriaQuery<?> query：封装了我们要执行的查询中的各个部分的信息，select  from order by
			 * CriteriaBuilder cb:查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				/**
				 * 参数一：查询的条件属性
				 * 参数二：条件的值
				 */
				Predicate pre = cb.equal(root.get("name"), "张三三");
				return pre;
			}
		};
		List<Users> list = this.usersRepositorySpecification.findAll(spec);
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	
	/**
	 * JpaSpecificationExecutor   多条件测试
	 */
	@Test
	public void testJpaSpecificationExecutor2() {
		
		/**
		 * Specification<Users>:用于封装查询条件
		 */
		Specification<Users> spec = new Specification<Users>() {
			
			//Predicate:封装了 单个的查询条件
			/**
			 * Root<Users> root:查询对象的属性的封装。
			 * CriteriaQuery<?> query：封装了我们要执行的查询中的各个部分的信息，select  from order by
			 * CriteriaBuilder cb:查询条件的构造器。定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三三' and age = 20
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"),"张三三"));
				list.add(cb.equal(root.get("age"),20));
				Predicate[] arr = new Predicate[list.size()];
				return cb.and(list.toArray(arr));
			}
		};
		List<Users> list = this.usersRepositorySpecification.findAll(spec);
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
