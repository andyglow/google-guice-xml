package org.google.inject.xml;

import org.google.inject.xml.adapter.CoreAdapter;
import org.google.inject.xml.test.I1;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test1 {

	
	
	public static void main(String[] args) {
		
		GuiceXMLHandler.register(CoreAdapter.NAMESPACE_URI, CoreAdapter.FACTORY);
		
		Injector gi = Guice.createInjector(new GuiceXMLModule(Test1.class.getResourceAsStream("test1.xml")));
		I1 bean = gi.getInstance(I1.class);
		System.out.println(bean.foo());
		
	}
	
}
