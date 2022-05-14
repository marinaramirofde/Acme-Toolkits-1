<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-integer code="inventor.item.form.label.number" path="number"/>
	<acme:input-select code="inventor.item-toolkit.form.label.typeEntity" path="item.typeEntity">
		<acme:input-option code="TOOL" value="TOOL" selected="${item.typeEntity == 'TOOL'}"/>
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${item.typeEntity == 'COMPONENT'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.item-toolkit.form.label.name" path="item.name"/>	
	<acme:input-textbox code="inventor.item-toolkit.form.label.code" path="item.code"/>
	<acme:input-textbox code="inventor.item-toolkit.form.label.technology" path="item.technology"/>
	<acme:input-textarea code="inventor.item-toolkit.form.label.description" path="item.description"/>
	<acme:input-money code="inventor.item-toolkit.form.label.retailPrice" path="item.retailPrice"/>
	<acme:input-url code="inventor.item-toolkit.form.label.link" path="item.link"/>
	
	<jstl:choose>
	<jstl:when test="${command == 'create'}">
		<acme:submit code="inventor.item-toolkit.list.button.create" action="/inventor/quantity/create?masterId=${masterId}"/>
	</jstl:when>		
	</jstl:choose>
</acme:form>