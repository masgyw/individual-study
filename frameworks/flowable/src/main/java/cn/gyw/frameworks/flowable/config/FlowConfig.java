package cn.gyw.frameworks.flowable.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.flowable.engine.FormService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.ManagementService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import cn.gyw.frameworks.flowable.config.condition.ProdFlowableCondition;

@Configuration
@Conditional(ProdFlowableCondition.class)
public class FlowConfig {
	
	@Bean(name = "customConfigFactory")
    public YamlPropertiesFactoryBean properties() {
      YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
      yaml.setResources(new ClassPathResource("custom.yml"));
      return yaml;
    }

	@Bean
	public DataSource driverDataSource() {
		SimpleDriverDataSource driverDataSource = new SimpleDriverDataSource();
		driverDataSource.setDriverClass(org.h2.Driver.class);
		driverDataSource.setUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=1000");
		driverDataSource.setUsername("sa");
		driverDataSource.setPassword("");
		return driverDataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(driverDataSource());
	}

	@Bean
	public SpringProcessEngineConfiguration springProcessEngineConfiguration() throws IOException {
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath*:/flows/**/*.*");
		SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
		springProcessEngineConfiguration.setDataSource(driverDataSource());
		springProcessEngineConfiguration.setTransactionManager(dataSourceTransactionManager());
		springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
		springProcessEngineConfiguration.setJpaHandleTransaction(true);
		springProcessEngineConfiguration.setJpaCloseEntityManager(true);
		springProcessEngineConfiguration.setAsyncExecutorActivate(true);
		springProcessEngineConfiguration.setHistory("none");
		springProcessEngineConfiguration.setDeploymentResources(resources);
		
		/*
		 * ?????????????????????????????????????????????????????????????????????
		 * default??????????????????????????????????????????,?????????
		 * single-resource??????????????????????????????????????????????????????????????????????????????????????????
		 * resource-parent-folder????????????????????????????????????????????????????????????????????????????????????????????????
		 */
		springProcessEngineConfiguration.setDeploymentMode("single-resource");
		
		// ?????????????????????spring beans?????????????????????????????????bean
		// springProcessEngineConfiguration.setBeans(beans);
		
		// ??????????????????????????????????????????????????????Flowable??????????????????????????????????????????????????????????????????????????????????????????????????????false
//		springProcessEngineConfiguration.setCreateDiagramOnDeploy(false);
		
		return springProcessEngineConfiguration;
	}

	@Bean
	public ProcessEngineFactoryBean processEngineFactoryBean() throws IOException {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration());
		return processEngineFactoryBean;
	}

	@Bean
	public RepositoryService repositoryService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getRuntimeService();
	}

	@Bean
	public HistoryService historyService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getHistoryService();
	}

	@Bean
	public ManagementService managementService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getManagementService();
	}

	@Bean
	public IdentityService identityService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getIdentityService();
	}

	@Bean
	public FormService formService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getFormService();
	}

	@Bean
	public TaskService taskService(ProcessEngineFactoryBean pefb) throws Exception {
		return pefb.getObject().getTaskService();
	}
	
}
