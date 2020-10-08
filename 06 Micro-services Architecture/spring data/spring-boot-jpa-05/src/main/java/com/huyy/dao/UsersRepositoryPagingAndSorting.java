package com.huyy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.huyy.pojo.Users;

/**
 * 
 *PagingAndSortingRepository接口
 *
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {

}
