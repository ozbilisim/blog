DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);
INSERT INTO ROLE (ID,ROLE_TITLE) VALUES (1,"ROLE_USER");
INSERT INTO ROLE (ID,ROLE_TITLE) VALUES (2,"ROLE_ADMIN");

INSERT INTO USER (ID,USERNAME,PASSWORD,FULL_NAME,EMAIL,ENABLED,LOGIN_DATE,JOIN_DATE) 
VALUES (1,"aqui","$2a$10$rVqQnmNJ8GUoh57mgvaKEOx.Z27KoxAFBBRF6dqiyZN9ZckQODDn6","Akif Batur","akifbatur@protonmail.com",true,CURDATE(),CURDATE());
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (1,2);

INSERT INTO USER (ID,USERNAME,PASSWORD,FULL_NAME,EMAIL,ENABLED,LOGIN_DATE,JOIN_DATE) 
VALUES (2,"tester","$2a$10$rVqQnmNJ8GUoh57mgvaKEOx.Z27KoxAFBBRF6dqiyZN9ZckQODDn6","Tester","tester@tester.com",true,CURDATE(),CURDATE());
INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES (2,1);
