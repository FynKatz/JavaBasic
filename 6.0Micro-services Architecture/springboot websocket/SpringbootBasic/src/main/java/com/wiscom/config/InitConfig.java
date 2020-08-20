package com.wiscom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "init-conf")
@PropertySource("file:./conf/init.properties")
@Component("initConfig")
public class InitConfig {

	private String webClient;

	public String getWebClient() {
		return webClient;
	}

	public void setWebClient(String webClient) {
		this.webClient = webClient;
	}
}
