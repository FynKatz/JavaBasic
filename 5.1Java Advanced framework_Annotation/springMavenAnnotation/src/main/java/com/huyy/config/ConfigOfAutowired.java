package com.huyy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**  
* 自动装配  
*/
@ComponentScan({"com.huyy.controller","com.huyy.service","com.huyy.dao"})
@Configuration
public class ConfigOfAutowired {

}
 