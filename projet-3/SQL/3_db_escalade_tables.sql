
CREATE SEQUENCE public.grimpeur_id_seq;

CREATE TABLE public.grimpeur (
                id INTEGER NOT NULL DEFAULT nextval('public.grimpeur_id_seq'),
                nom VARCHAR(40) NOT NULL,
                email VARCHAR(100) NOT NULL,
                CONSTRAINT grimpeur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.grimpeur_id_seq OWNED BY public.grimpeur.id;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                nom VARCHAR(300) NOT NULL,
                nb_pages INTEGER NOT NULL,
                auteur VARCHAR(100) NOT NULL,
                date DATE NOT NULL,
                createur_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE TABLE public.grimpeur_topo_proprietaire (
                proprietaire_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT grimpeur_topo_proprietaire_pk PRIMARY KEY (proprietaire_id, topo_id)
);


CREATE SEQUENCE public.commentaire_topo_id_seq;

CREATE TABLE public.commentaire_topo (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_topo_id_seq'),
                objet VARCHAR(100) NOT NULL,
                contenu VARCHAR(1000) NOT NULL,
                date DATE NOT NULL,
                auteur_id INTEGER NOT NULL,
                topo_commente_id INTEGER NOT NULL,
                CONSTRAINT commentaire_topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.commentaire_topo_id_seq OWNED BY public.commentaire_topo.id;

CREATE TABLE public.pret (
                topo_id INTEGER NOT NULL,
                emprunteur_id INTEGER NOT NULL,
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                CONSTRAINT pret_pk PRIMARY KEY (topo_id, emprunteur_id)
);


CREATE SEQUENCE public.administrateur_id_seq;

CREATE TABLE public.administrateur (
                id INTEGER NOT NULL DEFAULT nextval('public.administrateur_id_seq'),
                code_utilisateur VARCHAR(40) NOT NULL,
                mot_passe VARCHAR(40) NOT NULL,
                CONSTRAINT administrateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.administrateur_id_seq OWNED BY public.administrateur.id;

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                nom VARCHAR(300) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                nb_secteurs INTEGER NOT NULL,
                ville VARCHAR(150) NOT NULL,
                createur_id INTEGER NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;

CREATE SEQUENCE public.commentaire_site_id_seq;

CREATE TABLE public.commentaire_site (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_site_id_seq'),
                objet VARCHAR(100) NOT NULL,
                contenu VARCHAR(1000) NOT NULL,
                date DATE NOT NULL,
                auteur_id INTEGER NOT NULL,
                site_commente_id INTEGER NOT NULL,
                CONSTRAINT commentaire_site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.commentaire_site_id_seq OWNED BY public.commentaire_site.id;

CREATE TABLE public.topo_site_descipteur (
                site_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT topo_site_descipteur_pk PRIMARY KEY (site_id, topo_id)
);


CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                nom VARCHAR(300) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                nb_voies INTEGER NOT NULL,
                orientation VARCHAR(30) NOT NULL,
                coordonnees VARCHAR(150) NOT NULL,
                hauteur_max INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.Voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom VARCHAR(300) NOT NULL,
                nb_longueurs INTEGER NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.Voie.id;

CREATE SEQUENCE public.longueur_id_seq;

CREATE TABLE public.longueur (
                id INTEGER NOT NULL DEFAULT nextval('public.longueur_id_seq'),
                hauteur INTEGER NOT NULL,
                cotation VARCHAR(10) NOT NULL,
                nb_points INTEGER NOT NULL,
                equipee BOOLEAN NOT NULL,
                voie_id INTEGER NOT NULL,
                CONSTRAINT longueur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;

ALTER TABLE public.pret ADD CONSTRAINT grimpeur_pret_fk
FOREIGN KEY (emprunteur_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_site ADD CONSTRAINT grimpeur_commentaire_fk
FOREIGN KEY (auteur_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT grimpeur_commentaire_topo_fk
FOREIGN KEY (auteur_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.grimpeur_topo_proprietaire ADD CONSTRAINT grimpeur_grimpeur_topo_possession_fk
FOREIGN KEY (proprietaire_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT grimpeur_site_fk
FOREIGN KEY (createur_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT grimpeur_topo_fk
FOREIGN KEY (createur_id)
REFERENCES public.grimpeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_site_descipteur ADD CONSTRAINT topo_topo_site_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pret ADD CONSTRAINT topo_pret_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT topo_commentaire_topo_fk
FOREIGN KEY (topo_commente_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.grimpeur_topo_proprietaire ADD CONSTRAINT topo_grimpeur_topo_possession_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_site_descipteur ADD CONSTRAINT site_topo_site_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_site ADD CONSTRAINT site_commentaire_site_fk
FOREIGN KEY (site_commente_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT voie_longueur_fk
FOREIGN KEY (voie_id)
REFERENCES public.Voie (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;