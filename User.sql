--Crear nuevo usuario(esquema) con el password "PASSWORD" 
CREATE USER C##GOOGLEDRIVE
  IDENTIFIED BY "oracle"
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP;
--asignar cuota ilimitada al tablespace por defecto  
ALTER USER C##GOOGLEDRIVE QUOTA UNLIMITED ON USERS;

--Asignar privilegios basicos
GRANT create session TO C##GOOGLEDRIVE;
GRANT create table TO C##GOOGLEDRIVE;
GRANT create view TO C##GOOGLEDRIVE;
GRANT create any trigger TO C##GOOGLEDRIVE;
GRANT create any procedure TO C##GOOGLEDRIVE;
GRANT create sequence TO C##GOOGLEDRIVE;
GRANT create synonym TO C##GOOGLEDRIVE;
GRANT create materialized view TO C##GOOGLEDRIVE;