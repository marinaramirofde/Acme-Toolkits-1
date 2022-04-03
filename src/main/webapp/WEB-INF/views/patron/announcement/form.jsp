<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-moment code="patron.announcemeent.form.label.creationMoment" path="creationMoment"/>	
	<acme:input-textarea code="patron.announcemeent.form.label.title" path="title"/>
	<acme:input-textbox code="patron.announcemeent.form.label.body" path="body"/>
	<acme:input-textarea code="patron.announcemeent.form.label.criticalFlag" path="criticalFlag"/>
	<acme:input-url code="patron.announcemeent.form.label.link" path="link"/>
	
</acme:form>