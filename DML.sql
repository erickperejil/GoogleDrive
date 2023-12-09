-- DML_ERICK
INSERT INTO tbl_permisos (id_permiso, nombre_de_permiso) VALUES (1, 'lectura');
INSERT INTO tbl_permisos (id_permiso, nombre_de_permiso) VALUES (2, 'escritura');
INSERT INTO tbl_permisos (id_permiso, nombre_de_permiso) VALUES (3, 'comentario');

INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (1, 'pdf');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (2, 'png');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (3, 'docx');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (4, 'jpeg');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (5, 'xlsx');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (6, 'mp3');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (7, 'mp4');
INSERT INTO tbl_tipos_archivos (id_tipo_archivo, tipo_archivo) VALUES (8, 'txt');


INSERT INTO tbl_tipos_modificaciones (id_modificacion, nombre_modificacion) VALUES (1, 'creado');
INSERT INTO tbl_tipos_modificaciones (id_modificacion, nombre_modificacion) VALUES (2, 'editado');
INSERT INTO tbl_tipos_modificaciones (id_modificacion, nombre_modificacion) VALUES (3, 'compartido');

INSERT INTO tbl_estados_archivo (id_estado, tipo_estado) VALUES (1, 'activo');
INSERT INTO tbl_estados_archivo (id_estado, tipo_estado) VALUES (2, 'en papelera');
INSERT INTO tbl_estados_archivo (id_estado, tipo_estado) VALUES (3, 'destacado');
INSERT INTO tbl_estados_archivo (id_estado, tipo_estado) VALUES (4, 'spam');

INSERT INTO tbl_genero(id_genero, tipo_genero)VALUES ('1', 'F');
INSERT INTO tbl_genero(id_genero, tipo_genero)VALUES ('2', 'M');

INSERT INTO tbl_tipos_lugares (id_tipo_lugar, nombre_tipo) VALUES (1, 'ciudad');
INSERT INTO tbl_tipos_lugares (id_tipo_lugar, nombre_tipo) VALUES (2, 'departamento');
INSERT INTO tbl_tipos_lugares (id_tipo_lugar, nombre_tipo) VALUES (3, 'pais');
INSERT INTO tbl_tipos_lugares (id_tipo_lugar, nombre_tipo) VALUES (4, 'estado');

-- DML_RUTH
INSERT INTO tbl_tipos_modificaciones (id_modificacion, "TIPO DE MODIFICACION") VALUES (1, 'creado');
INSERT INTO tbl_tipos_modificaciones (id_modificacion, "TIPO DE MODIFICACION") VALUES (2, 'editado');
INSERT INTO tbl_tipos_modificaciones (id_modificacion, "TIPO DE MODIFICACION") VALUES (3, 'compartido');

INSERT INTO tbl_estado_archivo (id_estado, tipo_estado) VALUES (1, 'activo');
INSERT INTO tbl_estado_archivo (id_estado, tipo_estado) VALUES (2, 'en papelera');
INSERT INTO tbl_estado_archivo (id_estado, tipo_estado) VALUES (3, 'destacado');
INSERT INTO tbl_estado_archivo (id_estado, tipo_estado) VALUES (4, 'spam');

INSERT INTO tbl_genero(id, tipo_genero)VALUES ('1', 'F');
INSERT INTO tbl_genero(id, tipo_genero)VALUES ('2', 'M');


