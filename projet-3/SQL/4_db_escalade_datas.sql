
insert into grimpeur(nom, email) values('Abdellah','abd.mebarki@gmail.com')
insert into site(nom, description, nb_secteurs, ville,createur_id) values('FALAISE ECOLE', 'Granit compact en dalles et murs verticaux � petites prises', 1, 'AUZAT',1)
insert into secteur(nom,description,nb_voies,orientation,coordonnees,hauteur_max,site_id) values('Roxane Pipounette','Secteur d''initiation',1,'SO','48.856614  2.3522219000000177',20,2)
insert into voie(nom, nb_longueurs,secteur_id) values('Zoot allure', 1, 1)
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,1)



insert into grimpeur(nom, email) values('Abdellah','abd.mebarki@gmail.com')

select * from grimpeur
select * from site
select * from secteur
select * from voie
select * from longueur



insert into site(nom, description, nb_secteurs, ville,createur_id) values('FALAISE ECOLE', 'Granit compact en dalles et murs verticaux � petites prises', 2, 'AUZAT',1)


insert into secteur(nom,description,nb_voies,orientation,coordonnees,hauteur_max,site_id) values('Roxane Pipounette','Secteur d''initiation',2,'SO','48.856614  2.3522219000000177',20,4)
insert into secteur(nom,description,nb_voies,orientation,coordonnees,hauteur_max,site_id) values('Roxane Pipounette','Secteur d''initiation',2,'SO','48.856614  2.3522219000000177',20,4)

begin;
insert into voie(nom, nb_longueurs,secteur_id) values('Zoot allure', 2, 6);
insert into voie(nom, nb_longueurs,secteur_id) values('Zoot allure', 2, 6);
insert into voie(nom, nb_longueurs,secteur_id) values('Zoot allure', 2, 7);
insert into voie(nom, nb_longueurs,secteur_id) values('Zoot allure', 2, 7);
end;



begin;
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,7);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,7);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,8);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,8);

insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,9);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,9);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,10);
insert into longueur(hauteur, cotation, nb_points, equipee, voie_id) values(20, '6c+', 20, true,10);
end;

commit



select * from grimpeur
select * from topo
select * from site
select * from topo_site_descipteur
select * from grimpeur_topo_proprietaire


insert into topo(nom, nb_pages, auteur, date, createur_id) values('Topo escalade 2', 60, 'Auteur 2', '25-02-2017',1)

topo_id =2
site_id =3,4
grimpeur_id = 1

insert into topo_site_descipteur values(3,2)
insert into topo_site_descipteur values(3,3)

insert into grimpeur_topo_proprietaire values(1,2)


select * from topo t, topo_site_descipteur tsd where t.id = tsd.topo_id and tsd.site_id=3

select * from commentaire_site

select * from site

begin;
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,3);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,3);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,3);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,3);																					   
end;
																					   
begin;
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,4);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,4);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,4);
insert into commentaire_site(objet, contenu, date, auteur_id, site_commente_id) values('Site falaise','Excelent','22-04-2018',1,4);																					   
end;

select cs.* from commentaire_site cs, grimpeur g where cs.auteur_id = g.id and cs.site_commente_id = 3

select * from commentaire_site cs

select * from site s, grimpeur g where s.createur_id = g.id and s.id = 3

select t.id, t.nom as nom_topo, t.nb_pages, t.date, t.createur_id, gc.nom as nom_createur, gc.email as email_createur, gp.id proprietaire_id, gp.nom as nom_proprietaire, gp.email as email_proprietaire  from topo t, grimpeur gc,grimpeur gp, grimpeur_topo_proprietaire gtp where t.createur_id = gc.id and t.id = gtp.topo_id and gtp.proprietaire_id = gp.id and t.id=2

select s.id, s.description, s.nb_secteurs, s.ville, s.nom as nom_site, s.createur_id, g.nom as nom_createur, g.email from site s, grimpeur g where s.createur_id = g.id and s.id = ?

select * from topo where id=3 

select * from grimpeur

insert into grimpeur(nom, email) values('Toto', 'toto@gmail.com')

update grimpeur_topo_proprietaire set proprietaire_id=3 


select * from site s, topo_site_descipteur tsd where s.id = tsd.site_id and tsd.topo_id = 2


select * from commentaire_topo


select t.id, t.nom as nom_topo, t.nb_pages, t.date, t.auteur, t.createur_id, gc.nom as nom_createur, gc.email as email_createur, gp.id proprietaire_id, gp.nom as nom_proprietaire, gp.email as email_proprietaire  from topo t, grimpeur gc,grimpeur gp, grimpeur_topo_proprietaire gtp where t.createur_id = gc.id and t.id = gtp.topo_id and gtp.proprietaire_id = gp.id and t.id = 3


select t.id, t.nom as nom_topo, t.nb_pages, t.date, t.auteur, t.createur_id, gc.nom as nom_createur, gc.email as email_createur, gp.id proprietaire_id, gp.nom as nom_proprietaire, gp.email as email_proprietaire  
from topo t join grimpeur gc on t.createur_id = gc.id left join grimpeur_topo_proprietaire gtp on gtp.proprietaire_id = gp.id 
,grimpeur gp  left join g on t.id = gtp.topo_id  gtp where  and  and gtp.proprietaire_id = gp.id and t.id = 3

select * from grimpeur_topo_proprietaire

select * from topo t join grimpeur g on t.createur_id = g.id and t.id=3  left join grimpeur_topo_proprietaire gtp on t.id = gtp.topo_id left join grimpeur gp on gp.id = gtp.proprietaire_id


select * from site s, topo_site_descipteur tsd where s.id = tsd.site_id and tsd.topo_id=2
		