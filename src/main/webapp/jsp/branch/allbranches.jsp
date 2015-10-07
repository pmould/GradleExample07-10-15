<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
    <jsp:attribute name="header">
      <h2>List of Employees</h2>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table class="table">
        <tr>
            <td>Last Name</td>
            <td>Joining Date</td>
            <td>Salary</td>
            <td>Role</td>
            <td>Branch</td>
            <td>Department</td>
            <td>SSN</td>
            <td></td>
        </tr>
        <c:forEach items="${branches}" var="branch">
            <tr>
          	    <td>${branch.branchName}</td>
                <td>${branch.branchLoc}</td>
                <td><a href="<c:url value='/edit-${branch.branchId}-branch' />">${employee.ssn}</a></td>
                <td><a
                    href="<c:url value='/delete-${branch.branchId}-branch' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <a href="<c:url value='branches/new' />">Add New Branch</a>
    </jsp:body>
</t:layout>