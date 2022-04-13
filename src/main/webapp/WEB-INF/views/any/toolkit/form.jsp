<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
    <acme:input-textbox code="any.toolkit.form.label.code" path="code"/>
    <acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
    <acme:input-textarea code="any.toolkit.form.label.description" path="description"/>
    <acme:input-textarea code="any.toolkit.form.label.assembleNotes" path="assembleNotes"/>
    <acme:input-url code="any.toolkit.form.label.link" path="link"/>
    <acme:input-textbox code="any.toolkit.form.label.published" path="published"/>

    <acme:input-double code="any.toolkit.form.label.toolkitPrice" path="toolkitPrice"/>

    <acme:button code="any.toolkit.form.button.items" action="/any/item/list?itemId=${id}"/>

</acme:form>