<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
    <jsp:attribute name="header">
      <h2>Registration Confirmation Page</h2>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        message : ${success}
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Employees</a>
    
    </jsp:body>
</t:layout>