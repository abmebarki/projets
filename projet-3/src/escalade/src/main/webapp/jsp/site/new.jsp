<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/header.jsp"%>
</head>

<body><%@ include file="../_include/menu.jsp"%>
	<s:actionerror />
	<s:actionmessage />

	<h2>Création d'un site d'escalade</h2>

	<s:form action="site_new">

		<table>
			<tr>
				<td>Site</td>
			</tr>
			<tr>
				<td><s:textfield name="site.nom" label="Nom"
						requiredLabel="true" /></td>
			</tr>
			<tr>
				<td><s:textfield name="site.description" label="Description"
						requiredLabel="true" /></td>
			</tr>

			<tr>
				<td><s:checkboxlist label="Expositions" list="expositiontList"
						name="site.expositions" value="site.expositions" /></td>
			</tr>

			<tr>
				<td><s:textfield name="site.tempsApproche"
						label="Temps d'approche en Minutes" requiredLabel="true" /></td>
			</tr>

			<tr>
				<td><s:checkboxlist label="Saisons" list="saisonList"
						name="site.saisons" value="site.saisons" /></td>
			</tr>

			<tr>
				<td><s:textfield name="site.ville" label="Ville"
						requiredLabel="true" /></td>
			</tr>
			
			<tr>
			<s:iterator status="secteurStatus" begin="1" end="1">
			<td>
			
			<table>
			
				<tr>
					<td>Secteur <s:property value="%{#secteurStatus.index + 1}" /></td>
				</tr>
				<tr>
					<td><s:textfield
							name="site.secteurs[%{#secteurStatus.index}].nom" label="Nom"
							requiredLabel="true" /></td>
				</tr>
				<tr>
					<td><s:textfield
							name="site.secteurs[%{#secteurStatus.index}].description"
							label="Description" requiredLabel="true" /></td>
				</tr>

				<tr>
					<td><s:select
							name="site.secteurs[%{#secteurStatus.index}].type"
							list="typeList" label="Type" emptyOption="true"
							requiredLabel="true" /></td>
				</tr>

				<tr>
					<td><s:select
							name="site.secteurs[%{#secteurStatus.index}].difficulte"
							list="difficulteList" label="Difficulté" emptyOption="true"
							requiredLabel="true" /></td>


				</tr>

				<tr>
					<td><s:textfield
							name="site.secteurs[%{#secteurStatus.index}].coordonnees"
							label="Coordonnees" requiredLabel="true" /></td>
				</tr>
				<tr>
					<td><s:textfield
							name="site.secteurs[%{#secteurStatus.index}].hauteurMax"
							label="Hauteur Max" requiredLabel="true" /></td>
				</tr>

				<s:iterator status="voiesStatus" begin="1" end="1">
					<tr>
						<td>Voie <s:property value="%{#voiesStatus.index + 1}" /></td>
					</tr>
					<tr>
						<td><s:textfield
								name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].nom"
								label="Nom" requiredLabel="true" /></td>
					</tr>

					<s:iterator status="longueursStatus" begin="1" end="1">
						<tr>
							<td>Longueur <s:property value="%{#longueursStatus.index + 1}" /></td>
						</tr>
						<tr>
							<td><s:textfield
									name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].hauteur"
									label="hauteur" requiredLabel="true" /></td>
						</tr>
						<tr>
							<td><s:textfield
									name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].cotation"
									label="cotation" requiredLabel="true" /></td>
						</tr>
						<tr>
							<td><s:textfield
									name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].nbPoints"
									label="Nb Points" requiredLabel="true" /></td>
						</tr>
						<tr>
							<td><s:textfield
									name="site.secteurs[%{#secteurStatus.index}].voies[%{#voiesStatus.index}].longueurs[%{#longueursStatus.index}].equipee"
									label="equipée" requiredLabel="true" /></td>
						</tr>
					</s:iterator>
				</s:iterator>
			
			</table>
			
			 
			</td>
			</s:iterator>
			
			</tr>
			
			<s:if test="#session.user">					
				<tr>
					<td><s:hidden name="site.createur.id" value="%{session.user.id}"></s:hidden></td>
				</tr>
			</s:if>
			<tr>
			
				<td><s:checkbox label="Créer un nouveau topo"
						name="nouveauTopo" /></td>
			</tr>

			<tr>
				<td><s:if test="%{listTopo != null}">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td><s:select name="site.descripteurs.id" multiple="true"
										list="listTopo" listKey="id" listValue="nom"
										label="Selectionner un topo" emptyOption="true"
										requiredLabel="true" /></td>
							</tr>
						</table>
					</s:if></td>
			</tr>


			<tr>
				<td><s:submit value="OK" /></td>
			</tr>

		</table>

	</s:form>
</body>
</html>