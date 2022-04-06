<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
    <acme:input-textbox code="patron.systemconfiguration.form.label.accepted-currencies" path="acceptedCurrencies"/>
    <acme:input-textbox code="patron.systemconfiguration.form.label.system-currency" path="systemCurrency"/>
</acme:form>