package cn.gyw.community.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "cn.gyw.community.product")
//@EnableDubbo
//@DubboComponentScan(basePackages = {"cn.gyw.community.product.rpc"})
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "cn.gyw.community", "cn.gyw.platform" }, exclude = { FreeMarkerAutoConfiguration.class })
public class ProductApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProductApplication.class).bannerMode(Mode.OFF).build().run(args);
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
