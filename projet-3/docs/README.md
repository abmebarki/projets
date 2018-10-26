# Création d'un site communautaire autour de l’escalade

Ce fichier montre comment installer et déployer l'application " site communautaire autour de l’escalade " sur un serveur Tomcat.

Outils

- Eclipse IDE (Struts, Spring, Maven)

Prérequis

- Java/JEE (JDK 8) 
- Apache Tomcat 9 
- PostgreSQL 9.x

Données

Utiliser pgAdmin pour les étapes ci-dessous :

- Créer le propriétaire de la base de données avec le fichier : SQL/1_db_escalade_user.sql
- Créer la base de données avec le fichier : SQL/2_db_escalade_db.sql
- Créer les tables : SQL/3_db_escalade_tables.sql
- Créée les données : SQL / 4_db_escalade_datas.sql

Installation

-	Importer le projet sous forme de war dans Eclipse (voir livrable)
-	Ajouter le contenu du fichier context.xml au fichier server.xml : docs/context.xml
-	 Lancer l’application, l’url par défaut est la suivante : http://localhost:8080/escalade

Déploiement

-	Lancer tomcat 
-	Utiliser la manager pour déployer le war.
-	Remplir le formulaire de déploiement :
      Chemin de context (requis):	
      URL du fichier XML de configuration (context.xml):	
      URL vers WAR ou répertoire:
-     Déployer l'application      









