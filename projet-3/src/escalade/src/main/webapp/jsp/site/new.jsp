<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body>
	<div class="container">
		<%@ include file="../_include/menu.jsp"%>
		<s:actionerror />
		<s:actionmessage />
		<s:form action="site_new">
			<div class="row">
				<div class="col-6">
					<h3>Création d'un site d'escalade</h3>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="site_new_site_nom">Nom</label>
						<s:textfield class="form-control" name="site.nom" label="Nom" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_new_site_description">Description</label>
						<s:textfield class="form-control" name="site.description" label="Description" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_new_site_expositions" class="d-block">Expositions</label>
						<s:checkboxlist class="checkbox-inline" label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions"/>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="col">
					<div class="form-group">
						<label for="site_new_site.tempsApproche">Temps d'approche en Minutes</label>
						<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche en Minutes" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_new_site_saisons" class="d-block">Saisons</label>
						<s:checkboxlist class="checkbox-inline" label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_new_site_ville">Ville</label>
						<s:textfield class="form-control" name="site.ville" label="Ville" requiredLabel="true" required="true"/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-12">
					<div id="secteurs" class="clearfix">
						<a class="add_secteur" href="#">Ajouter une secteur<input type="hidden" class="nbSecteurs" value="1"></a>
						<div class="p-2 border border-primary secteur mr-1"><a class='remove float-right' href='#'>X</a>
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-12">
											<label class="font-weight-bold">Secteur&nbsp;<span class="secteur_index">1</span></label>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Nom</label>
												<s:textfield class="form-control" name="site.secteurs[0].nom" label="Nom" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Description</label>
												<s:textfield class="form-control" name="site.secteurs[0].description" label="Description" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Type</label>
												<s:select class="form-control" name="site.secteurs[0].type" list="typeList" label="Type" emptyOption="true" requiredLabel="true" required="true"/>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Difficulté</label>
												<s:select class="form-control" name="site.secteurs[0].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Coordonnees</label>
												<s:textfield class="form-control" name="site.secteurs[0].coordonnees" label="Coordonnees" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Hauteur Max</label>
												<s:textfield class="form-control" name="site.secteurs[0].hauteurMax" label="Hauteur Max" requiredLabel="true" required="true"/>
											</div>
										</div>
									</div>

								</div>
							</div>




							<div class="row">
								<div class="col">
									<div class="row">
										<div class="col">
											<div id="voies" class="clearfix">
											<a class="add_voie" href="#">Ajouter une voie<input type="hidden" class="nbVoies" value="1"></a>
												<div class="p-2 border border-success voie mr-1"><a class='remove float-right' href='#'>X</a>
													
													<div class="row">
														<div class="col">
															<label class="font-weight-bold">Voie&nbsp;<span class="voie_index">1</span></label>
															<div class="form-group">
																<label>Nom</label>
																<s:textfield class="form-control" name="site.secteurs[0].voies[0].nom" label="Nom" requiredLabel="true" required="true"/>
															</div>
															
															<div id="longueurs" class="clearfix">
															<a class="add_longueur clearfix" href="#">Ajouter une longueur<input type="hidden" class="nbLongueurs" value="1"></a>
																<div class="float-left p-2 border border-danger mr-1 longueur"> <a class='remove float-right' href='#'>X</a>
																	<label class="font-weight-bold">Longueur&nbsp;<span class="longueur_index">1</span></label>
																	
																	<div class="form-group">
																		<label>Hauteur</label>
																		<s:textfield class="form-control" name="site.secteurs[0].voies[0].longueurs[0].hauteur" label="Hauteur" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group">
																		<label>Cotation</label>
																		<s:textfield class="form-control" name="site.secteurs[0].voies[0].longueurs[0].cotation" label="Cotation" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group divNbPoints">
																		<label>Nb Points</label>
																		<s:textfield class="form-control nbPoints" name="site.secteurs[0].voies[0].longueurs[0].nbPoints" label="Nb Points" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group">
																		<label>Equipée</label>
																		<s:checkbox class="equipee" name="site.secteurs[0].voies[0].longueurs[0].equipee" label="Equipée" />
																	</div>
																</div>
															</div>
														</div>
														
														
														
													</div>



												</div>




											</div>
										</div>
									</div>



								</div>
							</div>




						</div>
					</div>
				</div>
			</div>
			<div class="row">
			<div class="col-6">
				<s:if test="#session.user">
					<s:hidden name="site.createur.id" value="%{session.user.id}"></s:hidden>
				</s:if>
				<div class="form-group">
					<label>Créer un nouveau topo</label>
					<s:checkbox label="Créer un nouveau topo" name="nouveauTopo" />
				</div>
				<s:if test="%{listTopo != null}">
					<div class="form-group">
						<label>Selectionner un topo</label>
						<s:select class="form-control" name="site.descripteurs.id" multiple="true" list="listTopo" listKey="id" listValue="nom" label="Selectionner un topo" emptyOption="true"/>
					</div>
				</s:if>
				<s:submit class="btn btn btn-primary btn-block" value="OK" />
			</div>
			</div>


		</s:form>
		<%@ include file="../_include/footer.jsp"%>
	</div>

	<script>
		$(document)
				.ready(
						function() {
							var i = 0;
							var j = 0;
							var k = 0;
							
							$(document).on('click', '.equipee', function () {
								
								if(!$(this).prop( "checked" )) {
									$(this).parent().parent().find('.divNbPoints').find('.nbPoints').val(0);
								} else {
									$(this).parent().parent().find('.divNbPoints').find('.nbPoints').val(1);
								}
								
							});
							
							$(document).on('click', '.add_secteur', function () {
												
												i = parseFloat($(this).find('.nbSecteurs').first().val());
												$(this).find('.nbSecteurs').first().val( i + 1 );
												
												// Dérnier secteur
												i = parseFloat($(this).parent().find('.secteur').last().find('.secteur_index').text());
												
												var regex = new RegExp('secteurs\\['+(i-1)+'\\]', 'g');
												var regex2 = '<span class="secteur_index">'+i+'</span>';
												
												
												var html = $(".secteur").html();
												html = "<div class='p-2 border border-primary secteur mr-1'>"
														+ html + "</div>";
												html = html.replace(regex,'secteurs[' + i + ']');
												html = html.replace(regex2,'<span class="secteur_index">'+(i+1)+'</span>');
												$(this).parent().append(html);
												$('html, body').animate({scrollTop: $( this ).parent().find('.secteur').last().offset().top - 300}, 500);
												
											});

							 $(document).on('click', '.add_voie', function () {
										
								 		j = parseFloat($(this).find('.nbVoies').first().val());
										$(this).find('.nbVoies').first().val( j + 1 );
										
										// Dérnière voie
										j = parseFloat($(this).parent().find('.voie').last().find('.voie_index').text());
										
										var regex = new RegExp('secteurs\\['+i+'\\].voies\\['+(j-1)+'\\]', 'g');
										var regex2 = '<span class="voie_index">'+j+'</span>';
										

										var html = $(".voie").html();
										html = "<div class='p-2 border border-success voie mr-1'>"
												+ html + "</div>";
										html = html.replace(regex,'secteurs[' + i + '].voies[' + j + ']');
										html = html.replace(regex2,'<span class="voie_index">'+(j+1)+'</span>');
										
										$(this).parent().append(html);
										$('html, body').animate({scrollTop: $( this ).parent().find('.voie').last().offset().top}, 500);
							});

							 $(document).on('click', '.add_longueur', function () {
								 
								 				// Nombre de longueurs
								                k = parseFloat($(this).find('.nbLongueurs').first().val());
												$(this).find('.nbLongueurs').first().val( k + 1 );
												
												// Dérnière longueur
												k = parseFloat($(this).parent().find('.longueur').last().find('.longueur_index').text());
												
												var regex = new RegExp('voies\\['+j+'\\].longueurs\\['+(k-1)+'\\]', 'g');
												var regex2 = '<span class="longueur_index">'+k+'</span>';

												var html = $(this).parent().find('.longueur').last().html();
												html = "<div class='float-left p-2 border border-danger longueur mr-1'>"
														+ html + "</div>";
														
												html = html.replace(regex,'voies[' + j + '].longueurs[' + k + ']');
												html = html.replace(regex2,'<span class="longueur_index">'+(k+1)+'</span>');
												
												$(this).parent().append(html);
												$('html, body').animate({scrollTop: $( this ).offset().top}, 500);
												
												
						});
							 
						$(document).on('click', '.remove', function () {
							
							//longueur
							if ($(this).parent().hasClass( 'longueur')) {
															
								var k = parseFloat($(this).parent().parent().find('.add_longueur').find('.nbLongueurs').first().val());
								
								if( k != 1) {
									$(this).parent().parent().find('.add_longueur').find('.nbLongueurs').first().val( k - 1 );	
								}else {
									alert("Suppression impossible, la voie doit être composée d'au moins une longueur");
									return;
								}
								
							}
							
							//voie
							if ($(this).parent().hasClass( 'voie' )) {
								
								var k = parseFloat($(this).parent().parent().find('.add_voie').find('.nbVoies').first().val());
								
								if( k != 1) {
									$(this).parent().parent().find('.add_voie').find('.nbVoies').first().val( k - 1 );	
								}else {
									alert("Suppression impossible, le secteur doit être composé d'au moins une voie");
									return;
								}
							}
							
							//secteur
							if ($(this).parent().hasClass( 'secteur' )) {
								
								var k = parseFloat($(this).parent().parent().find('.add_secteur').find('.nbSecteurs').first().val());
								
								if( k != 1) {
									$(this).parent().parent().find('.add_secteur').find('.nbSecteurs').first().val( k - 1 );	
								}else {
									alert("Suppression impossible, le site doit être composé d'au moins un secteur");
									return;
								}
								
							}
								
							 $(this).parent().remove();
						     return false;
						     
						});
							
						})
						
	</script>

</body>
</html>