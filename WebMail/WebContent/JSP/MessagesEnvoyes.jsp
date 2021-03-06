<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web Mail - Messages envoy�s</title>
<link type="text/css" rel="stylesheet" href="CSS/includes/Messages.css" />
<link type="text/css" rel="stylesheet" href="CSS/MessagesEnvoyes.css" />
</head>
<body>
	<div id="main">
		<%@include file="includes/Menu.jsp" %>
		<form method="POST" action="MessagesEnvoyes">
			<div id="tools">
				<input name="btnAfficherMessage"  type="submit" value="Afficher message"/>
				<input name="btnNouveauMessage"   type="submit" value="Nouveau message"/>
				<input name="btnSupprimerMessage" type="submit" value="Supprimer message"/>
			</div>
			<div id="messages">
				<table>
					<tr>
						<th class="checkbox"></th>
						<th class="date">Date</th>
						<th class="destinataire">Destinataire</th>
						<th class="objet">Objet</th>
					</tr>
					<c:forEach items="${messages}" var="message">
						<tr>
							<td class="checkbox"><input type="radio" name="id" value="${message.id}"></td>
							<td class="date">${message.date}</td>
							<td class="destinataire">${message.destinataire}</td>
							<td class="objet">${message.objet}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</body>
</html>