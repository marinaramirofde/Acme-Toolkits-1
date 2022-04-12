<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<acme:message code="patron.patron-dashboard.form.label.avg-title" />
<table class="table table-sm">
	<jstl:forEach items="${averageBudgetByCurrency}" var="entry">
		<tr>
			<th><acme:message
					code="patron.patron-dashboard.form.label.average-sentence" /> <jstl:set
					var="string1" value="${entry.key}" /> <jstl:set var="string2"
					value="${fn:split(string1, '->')}" /> <acme:print
					value="${string2[0]}" /> <acme:message
					code="patron.patron-dashboard.form.label.and-status" /> <acme:print
					value="${string2[1]}" /> <acme:message
					code="patron.patron-dashboard.form.label.colon" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>
<acme:message code="patron.patron-dashboard.form.label.deviationTitle" />
<table class="table table-sm">
	<jstl:forEach items="${deviationBudgetByCurrency}" var="entry">
		<tr>
			<th><acme:message
					code="patron.patron-dashboard.form.label.deviation-sentence" /> <jstl:set
					var="string1" value="${entry.key}" /> <jstl:set var="string2"
					value="${fn:split(string1, '->')}" /> <acme:print
					value="${string2[0]}" /> <acme:message
					code="patron.patron-dashboard.form.label.and-status" /> <acme:print
					value="${string2[1]}" /> <acme:message
					code="patron.patron-dashboard.form.label.colon" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>
<acme:message code="patron.patron-dashboard.form.label.minTitle" />
<table class="table table-sm">
	<jstl:forEach items="${minBudgetByCurrency}" var="entry">
		<tr>
			<th><acme:message
					code="patron.patron-dashboard.form.label.min-sentence" /> <jstl:set
					var="string1" value="${entry.key}" /> <jstl:set var="string2"
					value="${fn:split(string1, '->')}" /> <acme:print
					value="${string2[0]}" /> <acme:message
					code="patron.patron-dashboard.form.label.and-status" /> <acme:print
					value="${string2[1]}" /> <acme:message
					code="patron.patron-dashboard.form.label.colon" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>
<acme:message code="patron.patron-dashboard.form.label.maxTitle" />
<table class="table table-sm">
	<jstl:forEach items="${maxBudgetByCurrency}" var="entry">
		<tr>
			<th><acme:message
					code="patron.patron-dashboard.form.label.max-sentence" /> <jstl:set
					var="string1" value="${entry.key}" /> <jstl:set var="string2"
					value="${fn:split(string1, '->')}" /> <acme:print
					value="${string2[0]}" /> <acme:message
					code="patron.patron-dashboard.form.label.and-status" /> <acme:print
					value="${string2[1]}" /> <acme:message
					code="patron.patron-dashboard.form.label.colon" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>
<acme:message code="patron.patron-dashboard.form.label.absoluteTitle" />
<table class="table table-sm">
	<tr>
		<th><acme:message
				code="patron.patron-dashboard.form.label.totalNumberOfProposedPatronages" />

		</th>
		<td><acme:print value="${totalNumberOfProposedPatronages}" /></td>
	</tr>
	<tr>
		<th><acme:message
				code="patron.patron-dashboard.form.label.totalNumberOfAcceptedPatronages" />
		</th>
		<td><acme:print value="${totalNumberOfAcceptedPatronages}" /></td>
	</tr>
	<tr>
		<th><acme:message
				code="patron.patron-dashboard.form.label.totalNumberOfDeniedPatronages" />
		</th>
		<td><acme:print value="${totalNumberOfDeniedPatronages}" /></td>
	</tr>
</table>

<div>
    <canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        var data = {
            labels : [
            	"PROPOSED", "ACCEPTED", "DENIED"
            ],
            datasets : [
                {
                    data : [
                    	<jstl:out value="${totalNumberOfProposedPatronages}"/>, 
                        <jstl:out value="${totalNumberOfAcceptedPatronages}"/>, 
                        <jstl:out value="${totalNumberOfDeniedPatronages}"/>
                    ]
                }
            ]
        };
        var options = {
            scales : {
                yAxes : [
                    {
                        ticks : {
                            suggestedMin : 0.0,
                            suggestedMax : 1.0
                        }
                    }
                ]
            },
            legend : {
                display : false
            }
        };

        var canvas, context;

        canvas = document.getElementById("canvas");
        context = canvas.getContext("2d");
        new Chart(context, {
            type : "bar",
            data : data,
            options : options
        });
    });
</script>

<acme:return/>