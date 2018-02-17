CREATE SCHEMA "MYDB";

CREATE TABLE COUNTRIES
    (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY
    CONSTRAINT COUNTRIES_PK PRIMARY KEY, 
    
    DISPLAY_NAME VARCHAR(255),        
    EMAIL VARCHAR(255),
    UID VARCHAR(255)
    
    );
    
    select * from IDENTITIES;
    insert into IDENTITIES (DISPLAY_NAME, EMAIL, UID ) values('kabirou', 'k@g.com', 'ka');
     update IDENTITIES set EMAIL = 'karinloye@gmail.com' where id = 1;
     