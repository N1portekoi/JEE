<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web Mail - Connexion</title>
<link type="text/css" rel="stylesheet" href="CSS/Connexion.css" />
</head>
<body>
	<div id="main">
		<p>Web Mail</p>
		<form method="POST" action="Connexion">
			<input id="pseudo"     type="text"     name="pseudo"    placeholder="Pseudo"   maxlength="15">
			<input id="password"   type="password" name= "password" placeholder="Password" maxlength="15">
            <input type="submit"   value="Connexion" /><br />
		</form>
		<form method="GET" action="Enregistrement">
			<input type="submit"   value="S'enregistrer"/>
		</form>
	</div>
	<div id="message">
		${message}
	</div>
</body>
</html>