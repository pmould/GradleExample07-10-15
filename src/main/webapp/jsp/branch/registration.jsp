<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:layout>
	<jsp:attribute name="header">
      <h2>Branch Registration Form</h2>
    </jsp:attribute>
	<jsp:attribute name="footer">
    </jsp:attribute>
	<jsp:body>
	        <form:form method="POST" modelAttribute="branch">
	        <form:input type="hidden" path="branchId" id="id" />
	        <table>
	             <tr>
                    <td><label for="branch">Branch Name: </label></td>
                    <td><form:input path="branchName" id="" /></td>
                    <td><form:errors path="branchName" cssClass="error" /></td>
                </tr>
	            <tr>
	                <td><label for="branchLoc">Branch Location: </label></td>
	                <td><form:input path="branchLoc" id="lastName" /></td>
	                <td><form:errors path="branchLoc" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td colspan="3"><c:choose>
	                        <c:when test="${edit}">
	                            <input type="submit" value="Update" />
	                        </c:when>
	                        <c:otherwise>
	                            <input type="submit" value="Register" />
	                        </c:otherwise>
	                    </c:choose></td>
	            </tr>
	        </table>
	    </form:form>
	    <br />
	    <br /> Go back to
	    <a href="<c:url value='/branches' />">List of All Branches</a>
    </jsp:body>
</t:layout>


