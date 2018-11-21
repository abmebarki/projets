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
		<s:form action="site_update">
			<s:hidden name="site.id"></s:hidden>
			<div class="row">
				<div class="col-6">
					<h3>Mise à jour d'un site d'escalade</h3>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_nom">Nom</label>
						<s:textfield class="form-control" name="site.nom" label="Nom" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_description">Description</label>
						<s:textfield class="form-control" name="site.description" label="Description" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_expositions" class="d-block">Expositions</label>
						<s:checkboxlist class="checkbox-inline" label="Expositions" list="expositiontList" name="site.expositions" value="site.expositions"/>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="col">
					<div class="form-group">
						<label for="site_update_site.tempsApproche">Temps d'approche en Minutes</label>
						<s:textfield class="form-control" name="site.tempsApproche" label="Temps d'approche en Minutes" requiredLabel="true" required="true"/>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_saisons" class="d-block">Saisons</label>
						<s:checkboxlist class="checkbox-inline" label="Saisons" list="saisonList" name="site.saisons" value="site.saisons" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="site_update_site_ville">Ville</label>
						<s:textfield class="form-control" name="site.ville" label="Ville" requiredLabel="true" required="true"/>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="col-12">
					<div id="secteurs" class="clearfix">
						<s:iterator status="secteurStatus" value="site.secteurs">
						<div class="p-2 border border-primary secteur mr-1">
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-12">
											<label class="font-weight-bold">Secteur <s:property value="%{#secteurStatus.index} + 1}" /></label>
											<s:hidden name="site.secteurs[%{#secteurStatus.index}].id"></s:hidden>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Nom</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Description</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].description" label="Description" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Type</label>
												<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].type" list="typeList" label="Type" emptyOption="true" requiredLabel="true" required="true"/>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label>Difficulté</label>
												<s:select class="form-control" name="site.secteurs[%{#secteurStatus.index}].difficulte" list="difficulteList" label="Difficulté" emptyOption="true" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Coordonnees</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].coordonnees" label="Coordonnees" requiredLabel="true" required="true"/>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label>Hauteur Max</label>
												<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].hauteurMax" label="Hauteur Max" requiredLabel="true" required="true"/>
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
											<s:iterator status="voieStatus" value="voies">
												<div class="p-2 border border-success voie mr-1">
													
													<div class="row">
														<div class="col">
															<label class="font-weight-bold">Voie <s:property value="%{#voieStatus.index} + 1}" /></label>
															<s:hidden name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].id"></s:hidden>
															<div class="form-group">
																<label>Nom</label>
																<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].nom" label="Nom" requiredLabel="true" required="true"/>
															</div>
															
															<div id="longueurs" class="clearfix">
																<s:iterator status="longueurStatus" value="longueurs">
																<div class="float-left p-2 border border-danger mr-1 longueur">
																	<label class="font-weight-bold">Longueur <s:property value="%{#longueurStatus.index} + 1}" /></label>
																	<s:hidden name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].id"></s:hidden>
																	
																	<div class="form-group">
																		<label>Hauteur</label>
																		<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].hauteur" label="Hauteur" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group">
																		<label>Cotation</label>
																		<s:textfield class="form-control" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].cotation" label="Cotation" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group divNbPoints">
																		<label>Nb Points</label>
																		<s:textfield class="form-control nbPoints" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].nbPoints" label="Nb Points" requiredLabel="true" required="true"/>
																	</div>
																	<div class="form-group">
																		<label>Equipée</label>
																		<s:checkbox class="equipee" name="site.secteurs[%{#secteurStatus.index}].voies[%{#voieStatus.index}].longueurs[%{#longueurStatus.index}].equipee" label="Equipée" />
																	</div>
																</div>
																</s:iterator>
																</div>
														</div>
														
														
														
													</div>



												</div>
											</s:iterator>


											</div>
										</div>
									</div>



								</div>
							</div>
						</div>
						</s:iterator>	
					</div>
				</div>
			</div>
			<div class="row">
			<div class="col-6">
				<s:if test="#session.user">
					<s:hidden name="site.createur.id" value="%{session.user.id}"></s:hidden>
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
												i++;
												var regex = /secteurs\[0\]/g;
												var regex2 = /site_update_site_secteurs_0/g;
												var regex3 = '<label class="font-weight-bold">Secteur 1</label>';

												var html = $(".secteur").html();
												html = "<div class='p-2 border border-primary secteur mr-1'> <a class='remove float-right' href='#'>X</a>"
														+ html + "</div>";
												html = html.replace(regex,
														'secteurs[' + i
																+ ']');
												html = html.replace(regex2,
														'site_update_site_secteurs_'
																+ i);
												html = html.replace(regex3,'<label class="font-weight-bold">Secteur '+ (i+1)+ '</label>');
												$(this).parent().append(html);
												$('html, body').animate({scrollTop: $( this ).parent().find('.secteur').last().offset().top - 300}, 500);
												
											});

							 $(document).on('click', '.add_voie', function () {
										
								 		j = parseFloat($(this).find('.nbVoies').first().val());
										$(this).find('.nbVoies').first().val( j + 1 );
										
										var regex = /secteurs\[0\].voies\[0\]/g;
										var regex2 = /site_update_site_secteurs_0/g;
										var regex3 = '<label class="font-weight-bold">Voie 1</label>';

										var html = $(".voie").html();
										html = "<div class='p-2 border border-success voie mr-1'> <a class='remove float-right' href='#'>X</a>"
												+ html + "</div>";
										html = html.replace(regex,'secteurs[' + i + '].voies[' + j + ']');
										html = html.replace(regex3,'<label class="font-weight-bold">Voie '+ (j+1)+ '</label>');
										//html = html.replace(regex2,'site_update_site_secteurs_'+i);
										$(this).parent().append(html);
										$('html, body').animate({scrollTop: $( this ).parent().find('.voie').last().offset().top}, 500);
							});

							 $(document).on('click', '.add_longueur', function () {
								 
								                k = parseFloat($(this).find('.nbLongueurs').first().val());
												$(this).find('.nbLongueurs').first().val( k + 1 );
								 				
												//k++;
												var regex = /voies\[0\].longueurs\[0\]/g;
												var regex2 = /site_update_site_secteurs_0/g;
												var regex3 = '<label class="font-weight-bold">Longueur 1</label>';

												var html = $(".longueur").html();
												html = "<div class='float-left p-2 border border-danger longueur mr-1'> <a class='remove float-right' href='#'>X</a>"
														+ html + "</div>";
														
												html = html.replace(regex,'voies[' + j + '].longueurs[' + k + ']');
												html = html.replace(regex3,'<label class="font-weight-bold">Longueur '+ (k+1)+ '</label>');
												//html = html.replace(regex2,'site_update_site_secteurs_'+i);
												$(this).parent().append(html);
												$('html, body').animate({scrollTop: $( this ).offset().top}, 500);
												
												
						});
							 
						$(document).on('click', '.remove', function () {
							
							//longueur
							if ($(this).parent().hasClass( 'longueur')) {
								var k = parseFloat($(this).parent().parent().find('.add_longueur').find('.nbLongueurs').first().val());
								$(this).parent().parent().find('.add_longueur').find('.nbLongueurs').first().val( k - 1 );
				 			}
							
							//voie
							if ($(this).parent().hasClass( 'voie' )) {
								var k = parseFloat($(this).parent().parent().find('.add_voie').find('.nbVoies').first().val());
								$(this).parent().parent().find('.add_voie').find('.nbVoies').first().val( k - 1 );
							}
							
							//secteur
							if ($(this).parent().hasClass( 'secteur' )) {
								var k = parseFloat($(this).parent().parent().find('.add_secteur').find('.nbSecteurs').first().val());
								$(this).parent().parent().find('.add_secteur').find('.nbSecteurs').first().val( k - 1 );
							}
								
							 $(this).parent().remove();
						     return false;
						     
						});
							
						})
						
	</script>

</body>
</html>