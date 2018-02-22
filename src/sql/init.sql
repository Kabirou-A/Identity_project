CREATE SCHEMA "ROOT";

CREATE TABLE USERLOGINS (
    USERNAME varchar(50) NOT NULL,
    PASSWORD varchar(50) NOT NULL,
    
    PRIMARY KEY (USERNAME)
    
);

CREATE TABLE ADDRESS (
	ADDRESSNAME varchar(255) NOT NULL,
    OCCUPATION varchar(255) NOT NULL,
    STREETNAME varchar(255) NOT NULL,
	STATEAREADISTRICT varchar(255) NOT NULL,
    CITYTOWNVILLAGE varchar(255) NOT NULL,
	PROVINCE varchar(255) NOT NULL,
    POSTALCODE varchar(255) NOT NULL,
	COUNTRY varchar(255) NOT NULL,
   
    PRIMARY KEY (ADDRESSNAME),
    FOREIGN KEY (UID) REFERENCES IDENTITIES(UID)
);

CREATE TABLE IDENTITIES
    (
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY
    CONSTRAINT IDENTITY_PK PRIMARY KEY, 
    
    DISPLAY_NAME VARCHAR(255),
    EMAIL VARCHAR(255),
    UID  VARCHAR(255) NOT NULL
    
    );
    
    ALTER TABLE IDENTITIES
   	ADD CONSTRAINT PK_Person PRIMARY KEY (ID,UID);
	
    select * from IDENTITIES;
    insert into IDENTITIES (DISPLAY_NAME, EMAIL, UID ) values('kabirou', 'k@g.com', 'ka');
    update IDENTITIES set DISPLAY_NAME = 'Attanda' where id = 1;
    
    delete  from IDENTITIES where id = 411;
    
     
    
    DROP TABLE COUNTRIES;
    
    ALTER TABLE ADDRESS 
   
    
	ADD FOREIGN KEY (ID) REFERENCES IDENTITIES(ID);
	
    
    select * from IDENTITIES;
    insert into IDENTITIES (DISPLAY_NAME, EMAIL, UID ) values('kabirou', 'k@g.com', 'ka');
     update IDENTITIES set EMAIL = 'karinloye@gmail.com' where id = 1;
    