
/* Création des grimpeurs */
/* mot de passe hash B01D36918D0510F47EFBE55DFCE61B2D : mot de passe en clair : escalade */
/* mot de passe hash 098F6BCD4621D373CADE4E832627B4F6 : mot de passe en clair : test */
insert into grimpeur(nom, email, mot_passe, role) values('Test Admin','test.adm@gmail.com','B01D36918D0510F47EFBE55DFCE61B2D','ADMIN');
insert into grimpeur(nom, email, mot_passe, role) values('Test User 1','test.user1@gmail.com','098F6BCD4621D373CADE4E832627B4F6','USER');
insert into grimpeur(nom, email, mot_passe, role) values('Test User 2','test.user2@gmail.com','098F6BCD4621D373CADE4E832627B4F6','USER');

/* Création des sites */
insert into site(nom, description, temps_approche, ville, createur_id) values('FALAISE ECOLE', 'Granit compact en dalles et murs verticaux à petites prises',15,'AUZAT',(select last_value from grimpeur_id_seq));
insert into site_exposition values((select last_value from site_id_seq),'N');
insert into site_saison values((select last_value from site_id_seq),'ETE');
insert into secteur(nom,description,type,difficulte, coordonnees,hauteur_max,site_id) values('Roxane Pipounette','Secteur d''initiation','FALAISE','FACILE', '48.856614  2.3522219000000177',20,(select last_value from site_id_seq));
insert into voie(nom, secteur_id) values('Zoot allure',(select last_value from secteur_id_seq));
insert into voie(nom, secteur_id) values('Zoot allure 2',(select last_value from secteur_id_seq));


insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,(select last_value from voie_id_seq) - 1);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, false,(select last_value from voie_id_seq));


/* Création des topos */
insert into topo(nom, nb_pages, auteur, date, proprietaire_id) values('Topo escalade 2', 60, 'Auteur 2', '25-02-2017',(select last_value from grimpeur_id_seq));
insert into topo(nom, nb_pages, auteur, date, proprietaire_id) values('Topo escalade 4', 50, 'Auteur 5', '25-02-2018',(select last_value from grimpeur_id_seq));

/* Sites décrits par les topos */
insert into topo_site_descripteur values((select last_value from site_id_seq),(select last_value from topo_id_seq) - 1);
insert into topo_site_descripteur values((select last_value from site_id_seq),(select last_value from topo_id_seq));


/* Création des commentaires sites */
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',(select last_value from grimpeur_id_seq),(select last_value from site_id_seq));
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2019',(select last_value from grimpeur_id_seq),(select last_value from site_id_seq));

/* Création des commentaires topos */
insert into commentaire_topo(objet, contenu, date, auteur_id, topo_commente_id) values('Site falaise','Excelent','22-04-2018',(select last_value from grimpeur_id_seq),(select last_value from topo_id_seq) - 1);
insert into commentaire_topo(objet, contenu, date, auteur_id, topo_commente_id) values('Site falaise','Excelent','22-04-2019',(select last_value from grimpeur_id_seq),(select last_value from topo_id_seq) - 1);
insert into commentaire_topo(objet, contenu, date, auteur_id, topo_commente_id) values('Site falaise','Excelent','22-04-2018',(select last_value from grimpeur_id_seq),(select last_value from topo_id_seq));
insert into commentaire_topo(objet, contenu, date, auteur_id, topo_commente_id) values('Site falaise','Excelent','22-04-2019',(select last_value from grimpeur_id_seq),(select last_value from topo_id_seq));

/* Creation d'un prêt */
insert into pret(topo_id, emprunteur_id, date_debut, date_fin) values((select last_value from topo_id_seq),(select last_value from grimpeur_id_seq),'25-02-2017','28-02-2017'); 