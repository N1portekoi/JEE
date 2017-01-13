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
			</div>
			<div id="messages">
				<input class="expe" name="expediteur" type="text" placeholder="Expediteur" maxlength="15" disabled="disabled" value="${qui}">
				<input class="objet" name="objet"     type="text" placeholder="Objet"      maxlength="40" disabled="disabled" value="${objet}">
				<textarea class="message" name="message" maxlength="250" disabled="disabled">${message}</textarea>
			</div>
		</form>
	</div>
</body>
</html>