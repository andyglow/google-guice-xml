package org.google.inject.xml;

import org.google.inject.xml.adapter.CoreAdapter;
import org.google.inject.xml.util.Attrs;
import org.xml.sax.Attributes;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Names;

public abstract class AbstractXMLAdapter {

	private Binder binder;

	public AbstractXMLAdapter(Binder binder) {
		super();
		this.binder = binder;
	}
	
	protected Binder getBinder() {
		return binder;
	}

	public <T> void bind(Attrs attrs) throws Exception {
		
		/*
		 * bind
		 */
		Attrs.Attr typeAttr = attrs.get("type");
		if(typeAttr==null)
			// FIXME: or throw?
			return;
		
		Class<T> type = resolveClass(typeAttr.getValue());
		
		LinkedBindingBuilder<T> builder = binder.bind(type);

		/*
		 * annotatedWith
		 */
		Attrs.Attr annotatedWithAttr = attrs.get("named");
		if(annotatedWithAttr!=null) {
			if(builder instanceof AnnotatedBindingBuilder)
			builder = ((AnnotatedBindingBuilder<T>)builder).annotatedWith(Names.named(annotatedWithAttr.getValue()));
		}
		
		
		/*
		 * to
		 */
		String bindToName = attrs.getValue("to");
		if(bindToName!=null) {
			Class<T> bindTo = resolveClass(bindToName);
			builder.to(bindTo);
		}
		
	}

	protected <T> Class<T> resolveClass(String name) throws Exception {
		return (Class<T>) Class.forName(name);
	}
	
}
