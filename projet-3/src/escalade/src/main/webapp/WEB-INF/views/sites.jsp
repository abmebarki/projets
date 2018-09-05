<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>List des sites</title>
</head>
<body>

	<P>La liste des sites</P>

	<table>
		<tr>
			<td width="300"><b>Nom</b></td>
			<td width="300"><b>Description</b></td>
			<td width="300"><b>Nombre de secteurs</b></td>
			<td width="300"><b>Ville</b></td>
		</tr>

		<c:forEach var="site" items="${sites}">
			<tr>
				<td>${site.nom}</td>
				<td>${site.description}</td>
				<td>${site.nbSecteurs}</td>
				<td>${site.ville}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
