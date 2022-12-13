package cn.gyw.corejava;

import cn.gyw.platform.configuration.interfaces.IConfiguration;
import cn.gyw.platform.configuration.service.ConfigurationOnFileYaml;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

/**
 * KPTP工作日志生成
 */
@Slf4j
public class WorkLogByKPTPTest {

	private static IConfiguration configuration;

	/**
	 * 生成每周工作日志文件
	 */
	@Test
	public void generateWeekLog() {
		assert WorkLogByKPTP.generateWorkLogOfWeek(configuration.getValue("kptp", "kptp.dir"));
	}

	@Test
	public void shouldBuild() throws URISyntaxException {
		assert WorkLogByKPTP.buildCurrentYearWorkLog(configuration.getValue("kptp", "kptp.dir"));
	}

	@BeforeEach
	public void beforeEach() {
		log.info("kptp.kptp.dir :{}", configuration.getValue("kptp", "kptp.dir"));
	}

	@BeforeAll
	private static void before() {
		configuration = new ConfigurationOnFileYaml();
	}

}
