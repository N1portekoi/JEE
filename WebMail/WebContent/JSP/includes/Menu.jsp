<div id="menu">
	<p>${sessionScope.utilisateur.prenom}</p>
	<p>${sessionScope.utilisateur.nom}</p>
	<p>${sessionScope.adresse}</p>
	<form  method="POST" action="MessagesRecus">
		<input class="boutonMsg" type="submit"   value="Messages re�us" />
	</form>
	<form method="POST" action="MessagesEnvoyes">
		<input class="boutonMsg" type="submit"   value="Messages envoy�s" />
	</form>
	<form method="POST" action="MessagesIndesirables">
		<input class="boutonMsg" type="submit"   value="Messages ind�sirable" />
	</form>
	<form method="POST" action="MessagesSupprimes">
		<input class="boutonMsg" type="submit"   value="Messages Supprimes" />
	</form>
	<form method="POST" action="Adresses">
		<input class="boutonMsg" type="submit"   value="Changer d'adresse" />
	</form>
	<form method="GET" action="Connexion">
		<input class="boutonMsg" type="submit"   value="Deconnexion" />
	</form>
</div>