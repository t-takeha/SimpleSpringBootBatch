package com.example.ssbb.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.ssbb.model.MyFuncTestParam;

@Mapper
public interface MyFuncTestMapper {

	/**
	 * ストアードファンクション「MYFUNCTEST」を呼び出す
	 * @param param
	 */
	void exeucteMyFuncTest(MyFuncTestParam param);
}
