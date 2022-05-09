<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.patronage-report.form.label.automatic-sequence-number" path="automaticSequenceNumber"/>	
	<acme:input-moment code="inventor.patronage-report.form.label.creation" path="creation" readonly = "true"/>
	<acme:input-textarea code="inventor.patronage-report.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronage-report.form.label.link" path="link"/>
	
	<acme:input-checkbox code="inventor.patronage-report.form.label.confirmation" path="confirmation"/>
	
	<jstl:choose>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.patronage-report.form.button.create" action="/inventor/patronage-report/create"/>
		</jstl:when>
	</jstl:choose>
	
</acme:form>