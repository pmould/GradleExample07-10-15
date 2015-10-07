<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:layout>
	<jsp:attribute name="header">
      <h2>Registration Form</h2>
    </jsp:attribute>
	<jsp:attribute name="footer">
    </jsp:attribute>
	<jsp:body>
	        <form:form method="POST" modelAttribute="employee">
	        <form:input type="hidden" path="id" id="id" />
	        <table>
	             <tr>
                    <td><label for="firstName">First Name: </label></td>
                    <td><form:input path="firstName" id="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error" /></td>
                </tr>
	            <tr>
	                <td><label for="lastName">Last Name: </label></td>
	                <td><form:input path="lastName" id="lastName" /></td>
	                <td><form:errors path="lastName" cssClass="error" /></td>
	            </tr>
                <tr>
                    <td><label for="email">Email: </label></td>
                    <td><form:input path="email" id="email" /></td>
                    <td><form:errors path="email" cssClass="error" /></td>
                </tr>
	            <tr>
	                <td><label for="joiningDate">Joining Date: </label></td>
	                <td><form:input path="joiningDate"
							id="joiningDate" /></td>
	                <td><form:errors path="joiningDate"
							cssClass="error" /></td>
	            </tr>
	
	            <tr>
	                <td><label for="salary">Salary: </label></td>
	                <td><form:input path="salary" id="salary" /></td>
	                <td><form:errors path="salary" cssClass="error" /></td>
	            </tr>
	
	            <tr>
	                <td><label for="ssn">SSN: </label></td>
	                <td><form:input path="ssn" id="ssn" /></td>
	                <td><form:errors path="ssn" cssClass="error" /></td>
	            </tr>
	            <tr>
	                <td><label for="role">Role: </label></td>
	                <td><form:input path="role" id="role" /></td>
	                <td><form:errors path="role" cssClass="error" /></td>
	            </tr>
		<%-- 	 <tr>
	                <td><label for="dept">Branch: </label></td>
	                <td><form:input path="branch" id="branch" /></td>
	                <td><form:errors path="branch" cssClass="error" /></td>
	            </tr>	
           <tr>
	                <td><label for="dept">Department: </label></td>
	                <td><form:input path="department" id="dept" /></td>
	                <td><form:errors path="department" cssClass="error" /></td>
	            </tr> --%>	
	            <tr>	
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
	    <a href="<c:url value='/list' />">List of All Employees</a>
    </jsp:body>
</t:layout>









