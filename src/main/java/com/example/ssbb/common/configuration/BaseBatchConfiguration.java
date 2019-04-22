package com.example.ssbb.common.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BaseBatchConfiguration extends DefaultBatchConfigurer {

	@Autowired
	DataSource dataSource;

//	/**
//	 * Map（インメモリ）ベースのジョブリポジトリにするため、
//	 * DefaultBatchConfigurerが持っているデータソースを強制的にnullにする.
//	 */
//	@Override
//	public void setDataSource(DataSource dataSource) {
//		setDataSource(null);
//	}

	@Override
	protected JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(getTransactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}
