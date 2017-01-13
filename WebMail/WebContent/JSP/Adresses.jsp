<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web Mail - Adresses</title>
<link type="text/css" rel="stylesheet" href="CSS/Adresses.css" />
</head>
<body>
	<div id="main">
		<p class="utilisateur">${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom}</p>
		<form method="POST" action="Adresses">
			<select name="selectAdresse">
				<c:forEach items="${sessionScope.utilisateur.adresses}" var="adresse">
					<option value="${adresse}">${adresse}</option>
				</c:forEach>
			</select>
			<input name="btnVoirMessages"   type="submit"   value="Voir mes messages" />
			<input name="btnSupprimerEmail" type="submit"   value="Supprimer cette adresse"/>
			<input name="nouvelleAdresse"   type="text"     placeholder="Votre nouvelle adresse"   maxlength="15">
			<p>@condorcet.be</p>
			<input name="btnAjouterAdresse" type="submit"   value="Ajouter une adresse" />
		</form>
		<form method="GET" action="Connexion">
			<input type="submit"   value="Deconnexion" />
		</form>
	</div>
	<div  id="message">
		${message}
	</div>
</body>
</html>