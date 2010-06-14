package org.google.inject.xml;

import com.google.inject.Binder;

public interface IXMLAdapterFactory {

	public AbstractXMLAdapter create(Binder binder);
	
}
