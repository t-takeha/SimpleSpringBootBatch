package com.example.ssbb.common.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractJobConfiguration {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Autowired(required=true)
	JobExecutionListener jobExecutionListener;

	/**
	 * 指定されたjobnameの名称のジョブを新規作成する.
	 * 指定されたtaskletに対応するstepは1つだけとする
	 * @param jobname 作成するジョブ名称
	 * @param tasklet ジョブからキックされるtasklet
	 * @return Job 生成したジョブ
	 * @throws Exception
	 */
    public Job createSimplejob(String jobname, Tasklet tasklet) throws Exception {
    	System.out.println("### job = " + jobname + " ###");

    	return jobBuilderFactory.get(jobname)
    			.incrementer(new RunIdIncrementer())
    			.listener(jobExecutionListener)
    			.start(stepBuilderFactory.get("defaultJobStep").tasklet(tasklet).build())
    			.build();
    }
}
