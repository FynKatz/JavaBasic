package com.huyy.config;

import org.quartz.SchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.huyy.quartz.QuartzJob;

/**
 * Quartz配置类
 *
 *
 */
@Configuration
public class QuartzConfig {
	/**
	 * 1.创建Job对象
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		//关联我们自己的Job类
		factory.setJobClass(QuartzJob.class);
		return factory;
	}
	
	/**
	 * 2.创建Trigger对象
	 * 方式一：简单的Trigger
	 */
	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		//关联JobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//该参数表示一个执行的毫秒数
		factory.setRepeatInterval(2000);
		//重复次数
		factory.setRepeatCount(5);//重复5次
		return factory;
	}
	/**
	 * 方式二：Cron Trigger
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间
		factory.setCronExpression("0/2 * * * * ?");//每隔2秒定时
		return factory;
	}
	
	/**
	 * 3.创建Scheduler对象
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		//关联trigger
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		
		return factory;
	}
}
