<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web Mail - Nouveau message</title>
<link type="text/css" rel="stylesheet" href="CSS/includes/Messages.css" />
<link type="text/css" rel="stylesheet" href="CSS/NouveauMessage.css" />
</head>
<body>
	<div id="main">
		<%@include file="includes/Menu.jsp" %>
		<form method="POST" action="NouveauMessage">
			<div id="tools">
				<input name="btnEnvoyerMessage" type="submit" value="Envoyer"/>
			</div>
			<div id="messages">
				<input class="destinataire" name="destinataire" type="text" placeholder="Destinataire" maxlength="15">
				<input class="objet"        name="objet"        type="text" placeholder="Objet"        maxlength="40">
				<textarea class="message"   name="message"      maxlength="250"></textarea>
			</div>
		</form>
	</div>
</body>
</html>