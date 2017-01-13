<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web Mail - Adresses indésirables</title>
<link type="text/css" rel="stylesheet" href="CSS/AdressesInde.css" />
</head>
<body>
	<div id="main">
		<p class="utilisateur">${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom}</p>
		<form method="POST" action="AdressesIndesirables">
			<select name="selectAdresseInde">
				<c:forEach items="${adresses}" var="adresse">
					<option value="${adresse}">${adresse}</option>
				</c:forEach>
			</select>
			<input name="btnSupprimerAdresseInde" type="submit"   value="Retirer"/>
			<input name="nouvelleAdresseInde"   type="text"     placeholder="Adresse à bloquer"   maxlength="15">
			<p>@condorcet.be</p>
			<input name="btnAjouterAdresseInde" type="submit"   value="Ajouter" />
		</form>
		<form method="POST" action="MessagesIndesirables">
			<input type="submit"   value="Retour" />
		</form>
	</div>
	<div  id="message">
		${message}
	</div>
</body>
</html>