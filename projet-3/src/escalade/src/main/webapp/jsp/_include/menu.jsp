 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <s:a class="nav-link" action="site_list">Sites d'escalade <span class="sr-only">(current)</span></s:a>
          </li>
          <li class="nav-item">
            <s:a class="nav-link" action="topo_list">Topos d'escalade</s:a>
          </li>
          <li class="nav-item">
            <s:a class="nav-link" action="pret_list">Espace de prêt de topo</s:a>
          </li>
          <s:if test="#session.user">
		          <s:if test="#session.user.role.value() == 'USER'">
		          <li class="nav-item dropdown">
		            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mon espace</a>
		            <div class="dropdown-menu" aria-labelledby="dropdown01">
		              <s:a class="dropdown-item" action="mes_site_list"><s:param name="createurId" value="#session.user.id" />Mes sites</s:a>
		              <s:a class="dropdown-item" action="mes_topo_list"><s:param name="proprietaireId" value="#session.user.id" />Mes topos</s:a>
		              <s:a class="dropdown-item" action="mes_pret_list"><s:param name="emprunteurId" value="#session.user.id" />Mes prêts</s:a>
		            </div>
		          </li>
		          </s:if>
		          <s:elseif test="#session.user.role.value() == 'ADMIN'">
		          	<li class="nav-item">
            			<s:a class="nav-link" action="grimpeur_list">Les grimpeurs</s:a>
          			</li>
		          </s:elseif>
		          <li class="nav-item">
		          	<s:a class="nav-link" action="logout">Déconnexion</s:a>
		          </li>
		  </s:if>
          <s:else>
          <li class="nav-item">
	    	<s:a class="nav-link" action="login">Connexion</s:a>
	      </li>	
		 </s:else>
        </ul>
        <s:if test="#session.user">
        	<h6 class="text-secondary">Utilisateur connecté :<s:property value="#session.user.email" />&nbsp;<s:property value="#session.user.role"/></h6>
        </s:if>
      </div>
    </nav>