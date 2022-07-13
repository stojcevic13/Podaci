CREATE TABLE servis(
	 Idser integer NOT NULL,
	 Nazser varchar(20) NOT NULL,
	 Grad varchar(20) NOT NULL,
     
	 CONSTRAINT servis_PK PRIMARY KEY (Idser),
     CONSTRAINT servis_UK UNIQUE (Nazser)
);


CREATE TABLE proizvodjac
	(
	 Idproiz integer not null,
	 Nazproiz varchar(20),
     Brrad integer not null,
     
	 CONSTRAINT proizvodjac_PK PRIMARY KEY (Idproiz),
     CONSTRAINT proizvodjac_UK UNIQUE (Nazproiz)
);


CREATE TABLE ugovor
	(
     Idug integer NOT NULL,
	 Idser integer NOT NULL,
	 Idproiz integer NOT NULL,
     uslovi varchar(200),
	 CONSTRAINT ugovor_PK PRIMARY KEY (idug),
	 CONSTRAINT ugovor_ser_FK FOREIGN KEY (Idser) REFERENCES servis(Idser),
	 CONSTRAINT ugovor_proiz_FK FOREIGN KEY (Idproiz) REFERENCES proizvodjac(Idproiz)
);


CREATE TABLE masina
	(
	 Idmas integer not null,
	 Nazproiz varchar(20),
     proiz integer not null,
     
	 CONSTRAINT masina_PK PRIMARY KEY (Idmas),
	 CONSTRAINT masina_FK FOREIGN KEY (proiz) REFERENCES proizvodjac(Idproiz)
);
