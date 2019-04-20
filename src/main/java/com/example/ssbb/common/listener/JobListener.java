package com.example.ssbb.common.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobListener extends JobExecutionListenerSupport {

	@Bean
	public JobExecutionListener jobExecutionListener() {
		System.out.println("### listener ###");
		return new JobListener();
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		super.beforeJob(jobExecution);
		System.out.println("### START job ###");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		super.afterJob(jobExecution);
		System.out.println("### END  job ###");
	}
}
