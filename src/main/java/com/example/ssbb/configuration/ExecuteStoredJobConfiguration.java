package com.example.ssbb.configuration;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ssbb.common.configuration.AbstractJobConfiguration;
import com.example.ssbb.tasklet.ExecuteStoredTasklet;

@Configuration
public class ExecuteStoredJobConfiguration extends AbstractJobConfiguration {

	@Autowired
	ExecuteStoredTasklet tasklet;

	@Bean
    public Job executeStoredJob() throws Exception {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		return createSimplejob(methodName, tasklet);
	}

}
