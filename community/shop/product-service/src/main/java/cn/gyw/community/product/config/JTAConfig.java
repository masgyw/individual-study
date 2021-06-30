//package cn.gyw.community.product.config;
//
//import javax.transaction.SystemException;
//import javax.transaction.TransactionManager;
//import javax.transaction.UserTransaction;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import com.atomikos.icatch.jta.UserTransactionImp;
//import com.atomikos.icatch.jta.UserTransactionManager;
//
///**
// * XA 事务管理器配置
// */
//@Configuration
//@EnableTransactionManagement
//@DependsOn(value = "rootConfig")
//public class JTAConfig {
//	
//	/**
//	 * 用户事务
//	 * @return
//	 * @throws SystemException
//	 */
//	@Bean(name = "userTransaction")
//	public UserTransaction userTransaction() throws SystemException {
//		UserTransactionImp userTransactionImp = new UserTransactionImp();
//		userTransactionImp.setTransactionTimeout(10000);
//		return userTransactionImp;
//	}
//	
//	@Bean(name="atomikosTransactionManager")
//	public TransactionManager atomikosTransactionManager() {
//		UserTransactionManager userTransactionManager = new UserTransactionManager();
//		userTransactionManager.setForceShutdown(false);
//		return userTransactionManager;
//	}
//	
//	/**
//	 * 全局事务管理器，不需要其他事务管理器
//	 * @return
//	 * @throws SystemException
//	 */
//	@Bean("jtaTransactionManager")
//	@DependsOn({"userTransaction", "atomikosTransactionManager"})
//	public PlatformTransactionManager transactionManager() throws SystemException {
//		return new JtaTransactionManager(userTransaction(), atomikosTransactionManager());
//	}
//}
