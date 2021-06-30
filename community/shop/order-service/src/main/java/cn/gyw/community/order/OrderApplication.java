package cn.gyw.community.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

@DubboComponentScan(basePackages = "cn.gyw.community.order.service")
@SpringBootApplication(scanBasePackages = {"cn.gyw.community"})
public class OrderApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderApplication.class).bannerMode(Mode.OFF).build().run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Value("${server.port}") int port) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("start url :" + "http://127.0.0.1:" + port);
			}
		};
	}
	
}
