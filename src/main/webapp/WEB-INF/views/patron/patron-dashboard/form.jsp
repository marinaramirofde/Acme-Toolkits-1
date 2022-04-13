<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h2>
	<acme:message code="patron.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.total-number-of-proposed-patronages"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfProposedPatronages}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.total-number-of-accepted-patronages"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfAcceptedPatronages}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="patron.dashboard.form.label.total-number-of-denied-patronages"/>
		</th>
		<td>
			<acme:print value="${totalNumberOfDeniedPatronages}"/>
		</td>
	</tr>	
</table>

<h3>
	<acme:message code="patron.dashboard.form.title.application-average"/>
</h3>

<table class="table table-sm">
	<jstl:forEach items="${averageBudgeByPatronagesStatusAndCurrency}" var="entry">
		<tr>
			<th>
				<jstl:set var="pair" value="${entry.key}"/> 
				<jstl:set var="pairSplited" value="${fn:split(pair, '->')}"/> 
				<acme:print value="${pairSplited[0]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.currency"/> 
				<br/>
				<acme:print value="${pairSplited[1]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.status"/>
			</th>
			<td>
				<acme:print value="${entry.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<br/>

<h3>
	<acme:message code="patron.dashboard.form.title.application-deviation"/>
</h3>

<table class="table table-sm">
	<jstl:forEach items="${desviationBudgeByPatronagesStatusAndCurrency}" var="entry">
		<tr>
			<th>
				<jstl:set var="pair" value="${entry.key}"/>
				<jstl:set var="pairSplited" value="${fn:split(pair, '->')}"/> 
				<acme:print value="${pairSplited[0]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.currency"/> 
				<br/>
				<acme:print value="${pairSplited[1]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.status"/>
			</th>
			<td>
				<acme:print value="${entry.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<br/>

<h3>
	<acme:message code="patron.dashboard.form.title.application-max"/>
</h3>

<table class="table table-sm">
	<jstl:forEach items="${maximunBudgeByPatronagesStatusAndCurrency}" var="entry">
		<tr>
			<th>
				<jstl:set var="pair" value="${entry.key}"/>
				<jstl:set var="pairSplited" value="${fn:split(pair, '->')}"/> 
				<acme:print value="${pairSplited[0]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.currency"/>
				<br/>
				<acme:print value="${pairSplited[1]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.status"/>
			</th>
			<td>
				<acme:print value="${entry.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<br/>

<h3>
	<acme:message code="patron.dashboard.form.title.application-min"/>
</h3>

<table class="table table-sm">
	<jstl:forEach items="${minimunBudgeByPatronagesStatusAndCurrency}" var="entry">
		<tr>
			<th>
				<jstl:set var="pair" value="${entry.key}"/>
				<jstl:set var="pairSplited" value="${fn:split(pair, '->')}"/> 
				<acme:print value="${pairSplited[0]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.currency"/> 
				<br/>
				<acme:print value="${pairSplited[1]}"/> 
				<acme:message code="patron.patron-dashboard.form.label.status"/>
			</th>
			<td>
				<acme:print value="${entry.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>