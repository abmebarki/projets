<h1><s:text name="home.welcome" /></h1>
<nav class="navbar navbar-default">
  <ul class="nav nav-pills">
      <li role="presentation"> <s:a action="site_list"><s:text name="nav.listSite" /></s:a></li>
	  <li role="presentation"> <s:a action="topo_list"><s:text name="nav.listTopo" /></s:a></li>
	  <li role="presentation"> <s:a action="pret_list"><s:text name="nav.listPret" /></s:a></li>
	  
	   <s:if test="#session.user">
	   		<s:if test="#session.user.role == 'USER'">
		   		<li role="presentation"><s:a action="mes_site_list"><s:param name="createurId" value="#session.user.id" /><s:text name="nav.mes.listSite" /></s:a></li>
		   		<li role="presentation"><s:a action="mes_topo_list"><s:param name="proprietaireId" value="#session.user.id" /><s:text name="nav.mes.listTopo" /></s:a></li>
		   		<li role="presentation"><s:a action="mes_pret_list"><s:param name="emprunteurId" value="#session.user.id" /><s:text name="nav.mes.listPret" /></s:a></li>
	   		</s:if>
	     	<li role="presentation">
			Utilisateur connecté :
			<s:property value="#session.user.email" />&nbsp;<s:property value="#session.user.role" />
			<s:a action="logout">Déconnexion</s:a>
			</li>
		</s:if>
	    <s:else>
	    <li role="presentation">
			<s:a action="login">Connexion</s:a>
		</li>
	   </s:else>
</ul>
</nav>