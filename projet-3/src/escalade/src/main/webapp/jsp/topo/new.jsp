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

	<h2>Création d'un topo d'escalade</h2>
	
	<s:form action="topo_new">

		<table>
			<tr><td>Topo</td></tr>
			
			<tr>
				<td>
					<s:if test="%{site == null}">
						<s:if test="%{listSite != null}">
								<table cellpadding="5" cellspacing="5">
										<tr>
											<td>
											 	<s:select name="topo.descriptibles.id" multiple="true" list="listSite" listKey="id"  listValue="nom" label="Selectionner un site" emptyOption="false" requiredLabel="true"/>
											</td>
										</tr>
								</table>
						</s:if>
						<s:a action="site_new"><s:label>Ou créer un nouveau site</</s:label></s:a> 
					</s:if>
					<s:else>
						<s:label>Site</s:label><s:property value="%{site.nom}"/>
						<s:hidden name="topo.descriptibles.id" value="%{site.id}"></s:hidden>
					</s:else>	
				</td>
				<td>
				</td>
			</tr>
			<tr><td><s:textfield name="topo.nom" label="Nom" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.nbPages" label="Nb Pages" requiredLabel="true" /></td></tr>
			<tr><td><s:textfield name="topo.auteur" label="Auteur"	requiredLabel="true"/></td></tr>
			<tr><td><s:textfield name="topo.date" label="Date"	requiredLabel="true"/></td></tr>
			<s:if test="#session.user">					
				<tr>
					<td><s:hidden name="topo.proprietaire.id" value="%{session.user.id}"></s:hidden></td>
				</tr>
			</s:if>
			<tr><td><s:submit value="OK" /></td></tr>
			
		</table>
		
	</s:form>
</body>
</html>