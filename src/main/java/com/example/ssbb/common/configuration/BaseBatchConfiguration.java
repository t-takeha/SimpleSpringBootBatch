package com.example.ssbb.common.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BaseBatchConfiguration extends DefaultBatchConfigurer {

	/**
	 * Map（インメモリ）ベースのジョブリポジトリにするため、
	 * DefaultBatchConfigurerが持っているデータソースを強制的にnullにする.
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		setDataSource(null);
	}
}
