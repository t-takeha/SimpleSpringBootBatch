package com.example.ssbb.tasklet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.ssbb.common.tasklet.AbstractBaseTasklet;
import com.example.ssbb.mapper.MyFuncTestMapper;
import com.example.ssbb.model.MyFuncTestParam;

@Configuration
public class ExecuteStoredTasklet extends AbstractBaseTasklet {

	@Autowired
	MyFuncTestMapper myFuncTestMapper;

	/**
	 * ストアードファンクションを実行するタスクレット。
	 * (note)
	 *   トランザクションはタスクレット内で閉じています。
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		// ストアードファンクションに渡すパラメータを生成する
		MyFuncTestParam param = new MyFuncTestParam();
		// (note) PKには日時を設定する（ユニークになれば何でもOK）
		param.setIn1(LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuuMMddHHmmssSSS")));

		System.out.println("### param = " + param);

		// ストアードファンクションの呼び出し
		myFuncTestMapper.exeucteMyFuncTest(param);

		System.out.println("### result = " + param);

		return RepeatStatus.FINISHED;
	}
}
