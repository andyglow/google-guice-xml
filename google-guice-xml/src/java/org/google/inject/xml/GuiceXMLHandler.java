package org.google.inject.xml;

import java.util.HashMap;

import org.google.inject.xml.util.Attrs;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.inject.Binder;

public class GuiceXMLHandler extends DefaultHandler {

	private Binder binder;

	private static HashMap<String, IXMLAdapterFactory> factories = new HashMap<String, IXMLAdapterFactory>();
	private HashMap<String, AbstractXMLAdapter> adapters = new HashMap<String, AbstractXMLAdapter>();

	public GuiceXMLHandler(Binder binder) {
		super();
		this.binder = binder;
	}

	public static void register(String uri, IXMLAdapterFactory factory) {
		factories.put(uri, factory);
	}

	protected AbstractXMLAdapter adapterOf(String uri) {
		AbstractXMLAdapter adapter = adapters.get(uri);
		if (adapter == null) {
			IXMLAdapterFactory factory = factories.get(uri);
			if (factory == null)
				return null;
			adapter = factory.create(binder);
			adapters.put(uri, adapter);
		}
		return adapter;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		// System.out.println(uri + ". " + localName);
		AbstractXMLAdapter adapter = adapterOf(uri);
		if (adapter != null) {
			try {
				adapter.bind(new Attrs(attributes));
			} catch (Exception e) {
				throw new SAXException(e);
			}
		}

	}
}
