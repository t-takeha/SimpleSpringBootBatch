package com.example.ssbb.model;

public class MyFuncTestParam {

	private Integer rc;
	private String in1;
	private Integer out1;
	private String out2;

	public Integer getRc() {
		return rc;
	}
	public void setRc(Integer rc) {
		this.rc = rc;
	}
	public String getIn1() {
		return in1;
	}
	public void setIn1(String in1) {
		this.in1 = in1;
	}
	public Integer getOut1() {
		return out1;
	}
	public void setOut1(Integer out1) {
		this.out1 = out1;
	}
	public String getOut2() {
		return out2;
	}
	public void setOut2(String out2) {
		this.out2 = out2;
	}
	@Override
	public String toString() {
		return "MyFunctestParam [rc=" + rc + ", in1=" + in1 + ", out1=" + out1 + ", out2=" + out2 + "]";
	}
}
