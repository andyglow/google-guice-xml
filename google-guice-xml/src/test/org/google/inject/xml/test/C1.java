package org.google.inject.xml.test;

import com.google.inject.name.Named;

public class C1 implements I1{

	@Named("xxx.yyy")
	public String xxx = "0";
	
	public String foo() {
		return "C1.foo: "+xxx;
	}

	public void bar(String bar) {
	}
	
}
