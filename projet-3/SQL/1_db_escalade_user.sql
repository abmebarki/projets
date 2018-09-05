-- User: admin_escalade
-- DROP USER admin_escalade;

CREATE USER admin_escalade WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION;