package org.google.inject.xml.util;

import java.util.HashMap;

import org.xml.sax.Attributes;

public class Attrs {

	public static class Attr {
		private String localName;
		private String qName;
		private String namespaceURI;
		private String value;
		public String getLocalName() {
			return localName;
		}
		public String getqName() {
			return qName;
		}
		public String getNamespaceURI() {
			return namespaceURI;
		}
		public String getValue() {
			return value;
		}
		
	}
	
	private HashMap<String, Attr> map = new HashMap<String, Attr>();
	
	public Attrs(Attributes attrs) {
		int len = attrs.getLength();
		for(int i=0; i<len; i++) {
			String name = attrs.getLocalName(i);
			Attr attr = new Attr();
			attr.localName = name;
			attr.qName = attrs.getQName(i);
			attr.namespaceURI = attrs.getURI(i);
			attr.value = attrs.getValue(i);
			map.put(name, attr);
		}
	}

	public boolean has(String name) {
		return map.containsKey(name);
	}
	
	public Attr get(String name) {
		return map.get(name);
	}

	public String getValue(String name) {
		Attr attr = map.get(name);
		if(attr==null) return null;
		return attr.getValue();
	}
	
}
