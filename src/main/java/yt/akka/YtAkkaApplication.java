package yt.akka;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目主启动类
 *
 * @author yunteng
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class YtAkkaApplication {

	public static void main(String[] args) {
		MDC.put("request-id", "-");
		SpringApplication.run(YtAkkaApplication.class, args);
	}


}
