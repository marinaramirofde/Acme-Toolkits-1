<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-integer code="inventor.item.form.label.number" path="number"/>
	<acme:input-select code="inventor.item.form.label.item" path="itemId">
		<jstl:forEach items="${items}" var="item">
			<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${item.getId() == itemId }"/>
		</jstl:forEach>
	</acme:input-select>	
	<jstl:choose>
	<jstl:when test="${command == 'create'}">
		<acme:submit code="inventor.item-toolkit.form.button.create" action="/inventor/quantity/create?masterId=${masterId}"/>
	</jstl:when>		
	</jstl:choose>
</acme:form>