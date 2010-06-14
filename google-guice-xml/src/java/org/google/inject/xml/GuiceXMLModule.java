package org.google.inject.xml;


import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.google.inject.*;

public class GuiceXMLModule extends AbstractModule {

	private InputStream is;
	
	public GuiceXMLModule(InputStream is) {
		super();
		this.is = is;
	}

	@Override
	protected void configure() {
		
		try {
			GuiceXMLHandler handler = new GuiceXMLHandler(binder());
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();
			parser.parse(is, handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
