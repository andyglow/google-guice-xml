package org.google.inject.xml.adapter;

import org.google.inject.xml.AbstractXMLAdapter;
import org.google.inject.xml.IXMLAdapterFactory;
import org.xml.sax.Attributes;

import com.google.inject.Binder;

public class CoreAdapter extends AbstractXMLAdapter {

	public static final IXMLAdapterFactory FACTORY = new IXMLAdapterFactory() {
		
		@Override
		public AbstractXMLAdapter create(Binder binder) {
			return new CoreAdapter(binder);
		}
	};
	
	private CoreAdapter(Binder binder) {
		super(binder);
	}

	public static final String NAMESPACE_URI = "http://code.google.com/schema/inject/core";

	
}
