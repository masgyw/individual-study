package cn.gyw.community.search.config;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 参考：https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#preface.versions
 */
@Configuration
public class ElasticConfig {

	@Autowired
	private RestHighLevelClient client;

	@Bean
	public RestHighLevelClient restClient(@Value("${es.host}") String host, @Value("${es.port}") int port,
			@Value("${es.schema}") String schema) {
		System.out.println(host + ":" + port + ":" + schema);
		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
				RestClient.builder(new HttpHost(host, port, schema)));
		return restHighLevelClient;
	}

	@PreDestroy
	public void destroy() {
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
