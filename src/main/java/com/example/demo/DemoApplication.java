package com.example.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@Slf4j
@MapperScan("com.example.demo.mapper")
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {

//		User user = userService.getUser();
//		log.info("user: {}", user);
	}

	private void printLoggingStatus() {
		log.info("logback日志状态：");
		// assume SLF4J is bound to logback in the current environment
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);
	}

//	@Bean
//	public Realm realm() {
//		return new MyBatisRealm();
//	}
//	@Bean
//	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//
//		// logged in users with the 'admin' role
//		chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
//
//		// logged in users with the 'document:read' permission
//		chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
//
//		// all other paths require a logged in user
//		chainDefinition.addPathDefinition("/**", "authc");
//		return chainDefinition;
//	}


}
