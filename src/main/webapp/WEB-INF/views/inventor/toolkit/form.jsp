<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>	
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>	
	<acme:input-textarea code="inventor.toolkit.form.label.assembleNotes" path="assemblyNotes"/>
	<acme:input-url code="inventor.toolkit.form.label.link" path="link"/>
	
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.item.form.button.create" action="/inventor/toolkit/create-toolkits"/>
		</jstl:when>
		<jstl:when test="${command == 'show'}">
			<acme:input-textbox code="inventor.toolkit.form.label.toolkitPrice" path="price" readonly="true"/>
			<acme:input-textbox code="inventor.toolkit.form.label.published" path="published" readonly="true"/>
		</jstl:when>
	</jstl:choose>
	
	<acme:button test="${command == 'show'}" code="inventor.toolkit.form.button.items" action="/inventor/quantity/list-toolkit-items?masterId=${id}"/>
</acme:form>