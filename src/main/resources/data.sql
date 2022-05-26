INSERT INTO ROLE (ID,DESCRIPTION) values (1,'ROLE_USER_CREATE')
INSERT INTO ROLE (ID,DESCRIPTION) values (2,'ROLE_AUTH_IDENTITY_USER')
INSERT INTO ROLE (ID,DESCRIPTION) values (3,'ROLE_AUTH_GET_ROLES')
INSERT INTO ROLE (ID,DESCRIPTION) values (4,'ROLE_TEST_CREATE')
INSERT INTO ROLE (ID,DESCRIPTION) values (5,'ROLE_TEST_UPDATE')
INSERT INTO ROLE (ID,DESCRIPTION) values (6,'ROLE_TEST_DELETE')
INSERT INTO ROLE (ID,DESCRIPTION) values (7,'ROLE_AUTH_REFRESH_TOKEN')
INSERT INTO ROLE (ID,DESCRIPTION) values (8,'ROLE_CHANGE_PASSWORD_ROLE')
INSERT INTO ROLE (ID,DESCRIPTION) values (9,'ROLE_TEST_FINDALL')
INSERT INTO ROLE (ID,DESCRIPTION) values (10,'ROLE_RESET_PASSWORD_ROLE')
INSERT INTO ROLE (ID,DESCRIPTION) values (11,'ROLE_TEST_FIND')


INSERT INTO PROFILE (ID,DESCRIPTION) values (1,'Administrador')
INSERT INTO PROFILE (ID,DESCRIPTION) values (2,'Analista')

INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,1)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,2)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,3)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,4)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,5)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,6)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,7)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,8)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,9)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,10)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (1,11)

INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (2,7)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (2,8)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (2,9)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (2,10)
INSERT INTO PROFILE_ROLE (PROFILE_ID,ROLE_ID) values (2,11)



INSERT INTO USUARIO (ID,NAME,USERNAME,PASSWORD,PROFILE_ID) values (1,'Usuário Asministrador','admin','jah',1)
INSERT INTO USUARIO (ID,NAME,USERNAME,PASSWORD,PROFILE_ID) values (2,'User Analista','analista','jah',2)