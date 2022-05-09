<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.patronage-report.list.label.creation" path="creation" width="50%"/>
	<acme:list-column code="inventor.patronage-report.list.label.patronage" path="patronageId" width="50%"/>
	
</acme:list>

<jstl:if test="${command == 'list-mine'}">
	<acme:button code="inventor.patronage-report.list.button.create" action="/inventor/patronage-report/create"/>
</jstl:if>