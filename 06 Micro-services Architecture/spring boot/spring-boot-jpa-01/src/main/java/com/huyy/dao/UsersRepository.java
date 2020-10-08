package com.huyy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyy.pojo.Users;
/**JpaRepository<T,ID>中，
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的主键的类型
 *
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {

}

