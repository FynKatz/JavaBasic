package com.huyy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springBoot 整合Listener
 */
@WebListener
public class FirstListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("LIstener..destoryed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Listener...init......");
	}
}