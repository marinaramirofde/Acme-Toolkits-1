<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.patronage.list.label.status" path="status"/>
	<acme:list-column code="patron.patronage.list.label.code" path="code"/>	
	<acme:list-column code="patron.patronage.list.label.budget" path="budget"/>
	<acme:list-column code="patron.patronage.list.label.creation" path="creation"/>
	
</acme:list>