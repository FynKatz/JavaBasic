package com.huyy.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.huyy.bean.User;
import com.huyy.service.UserService;

/**  
* @Description: 自定义realm
* @author yyhu
* @date 2020年6月14日  
* @version V1.0  
*/
public class UserRealm extends AuthorizingRealm{

	@Resource
	UserService userService;
	
	/**
	*  执行授权逻辑 
	*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑 ");
		
		// 给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		// 添加资源的授权字符串
//		info.addStringPermission("user:add");

		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		User dbUser = userService.getUserByName(user.getName());
		
		info.addStringPermission(dbUser.getPerm());
		
		return info;
	}

	
	/**
	*  执行认证逻辑 
	*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		System.out.println("执行认证逻辑 ");

		// 编写shiro判断逻辑，判断用户名和密码
		// 1.判断用户名
		UsernamePasswordToken token2 = (UsernamePasswordToken)token;
		User user = userService.getUserByName(token2.getUsername());
				
		if (user == null) {
			// 用户名不存在
			return null;// shiro底层会抛出UnKnowAccountException
		}

		// 2.判断密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

}
 