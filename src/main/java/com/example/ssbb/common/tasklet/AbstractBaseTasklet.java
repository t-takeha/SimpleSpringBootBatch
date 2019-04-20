package com.example.ssbb.common.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public abstract class AbstractBaseTasklet implements Tasklet {

	@Override
	public abstract RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception;

}
