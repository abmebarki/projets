<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title></title>
<body>
	<h2></h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Mettre � jour  Pr�t</h3>
	<form method="POST" name="update_pret" action="<%=request.getContextPath()%>/update/pret">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Date d�but: <input name="dateDebut" value="${pret.dateDebut}" type="text" />
		<br />
		<br /> 
		Date fin: <input name="dateFin" value="${pret.dateFin}" type="text" /> 
		<br />
		<br /> 
		<input value="Mettre � jour Pr�t" type="submit" />
	</form>
</body>
</html>