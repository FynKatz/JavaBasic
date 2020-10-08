package com.huyy.test;

import java.util.List;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.dao.UsersRepositoryPagingAndSorting;
import com.huyy.pojo.Users;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;

	/**
	 * PagingAndSortingRepository 排序测试
	 */
	@Test
	public void testPagingAndSortingRepositorySort() {
		// Order 定义排序规则
		Order order = new Order(Direction.DESC, "id");
		// Sort对象封装了排序规则
		Sort sort = new Sort(order);
		List<Users> list = (List<Users>) this.usersRepositoryPagingAndSorting.findAll(sort);
		for (Users users : list) {
			System.out.println(users);
		}
	}

	/**
	 * PagingAndSortingRepository 分页测试
	 */
	@Test
	public void testPagingAndSortingRepositoryPaging() {
		// Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前页是从0开始。
		// PageRequest(page,size) page:当前页。size:每页显示的条数
		Pageable pageable = new PageRequest(1, 2);
		Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数：" + page.getTotalElements());
		System.out.println("总页数" + page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}

	/**
	 * PagingAndSortingRepository 排序+分页
	 */
	@Test
	public void testPagingAndSortingRepositorySortAndPaging() {

		Sort sort = new Sort(new Order(Direction.DESC, "id"));

		Pageable pageable = new PageRequest(1, 2, sort);

		Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数：" + page.getTotalElements());
		System.out.println("总页数" + page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
