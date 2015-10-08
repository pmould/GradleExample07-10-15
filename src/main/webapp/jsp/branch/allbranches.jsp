<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
    <jsp:attribute name="header">
      <h2>List of Branches</h2>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table class="table">
        <tr>
            <td>Branch Name</td>
            <td>Branch Location</td>
            <td>Edit</td>
            <td></td>
        </tr>
        <c:forEach items="${branches}" var="branch">
            <tr>
          	    <td>${branch.branchName}</td>
                <td>${branch.branchLoc}</td>
                <td><a href="<c:url value='/edit-${branch.branchId}-branch' />">Edit-${branch.branchId}</a></td>
        </c:forEach>
    </table>
    <br />
    <a href="<c:url value='branches/new' />">Add New Branch</a>
    </jsp:body>
</t:layout>