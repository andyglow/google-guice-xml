Google Guice module, configured via simple xml description.
Like this:
```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="http://code.google.com/schema/inject/core"
	xmlns:jndi="http://code.google.com/schema/inject/jndi">
	
	<bind type="org.google.inject.xml.test.I1" to="org.google.inject.xml.test.C1"/>
	<bind type="java.lang.String" named="" to="foobar"/>

	<jndi:bind type="java.sql.DataSource" jndi:to="env/java/someDS"/>
	
</module>
```