--create database MURUN;

DROP TABLE MURUN.ADDRESS;
CREATE TABLE MURUN.ADDRESS (
  ID      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  STREET  VARCHAR(20)      NOT NULL,
  CITY    VARCHAR(20)      NOT NULL,
  STATE   VARCHAR(2)       NOT NULL,
  ZIPCODE VARCHAR(5)       NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
);


DROP TABLE MURUN.ASSET;
CREATE TABLE MURUN.ASSET (
  ID       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  TYPE     VARCHAR(50)   NOT NULL,
  TITLE     VARCHAR(100)   NOT NULL,
  ASSETDATA LONGBLOB      NOT NULL,

  PRIMARY KEY (`ID`) USING BTREE

)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
);



INSERT INTO MURUN.ADDRESS (id, STREET, CITY, STATE, ZIPCODE) VALUES (1, 'STREET-1', 'CITY-1', 'AL', '90401');


INSERT INTO MURUN.ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES ('STREET-2', 'CITY-1', 'CA', '90402');
INSERT INTO MURUN.ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES ('STREET-3', 'SANTA MONICA', 'CA', '90402');
INSERT INTO MURUN.ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES ('STREET-4', 'SAN JOSE', 'CA', '90404');
INSERT INTO MURUN.ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES ('STREET-5', 'SANTA MONICA', 'CA', '90404');
INSERT INTO MURUN.ADDRESS (STREET, CITY, STATE, ZIPCODE) VALUES ('STREET-6', 'SAN DIEGO', 'CA', '90404');


COMMIT;

SELECT * FROM MURUN.ADDRESS

