package cn.gyw.demo.seckill.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

@DubboComponentScan(basePackages = {"cn.gyw.demo.seckill.inventory.service"})
@SpringBootApplication(scanBasePackages = {"cn.gyw.demo", "cn.gyw.components.web.external"})
public class InventoryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(InventoryApplication.class).bannerMode(Mode.OFF).build().run(args);
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
