CREATE database Dentiste;
--Employer

create table Genre(
	 	id_Genre serial primary key NOT NULL,
	 	nomGenre varchar(1)
);
 
create table Niveaux
	(
	 	id_Niveaux serial primary key NOT NULL,
	 	nomNiveaux varchar(10)
	);

create table Employer
	(
	 	id_Employer serial primary key NOT NULL,
	 	nom varchar(100),
        prenom varchar(100),
        date_naissance date,
        id_Genre int references Genre(id_Genre),
        id_Niveaux int references Niveaux(id_Niveaux),
        salaire int
	);

create table Specialite
	(
	 	id_Specialite serial primary key NOT NULL,
	 	nomSpecialite varchar(100)
	);

create table EmployerSpecialite
	(
        id_Employer int references Employer(id_Employer),
        id_Specialite int references Specialite(id_Specialite)
	);

--Admin

create table Admins(
    idAdmin serial primary key NOT NULL,
    Email VARCHAR(20),
    passwords VARCHAR(30)
);


CREATE TABLE Charge_Scolaire(
    idChargeScolaire serial primary key NOT NULL,
    Ecolage INT,
    Droit INT,
    Autre INT,
    nbeAnnee INT
);

CREATE TABLE  Charge_fixe(
    idChargefixe serial primary key NOT NULL,
    nom_Charge VARCHAR(30),
    mois date,
    Cout int
);

--client
CREATE TABLE Client(
    idClient serial primary key NOT NULL,
    Email VARCHAR(30),
    passwords VARCHAR(30),
    nom VARCHAR(20),
    prenom VARCHAR(30),
    date_naissance date ,
    estFidele boolean, 
    idGenre int,
    FOREIGN KEY(idGenre) REFERENCES Genre(id_Genre)
);

--fonctionnalite

CREATE TABLE Services(
    idService  serial primary key NOT NULL,
    nomService VARCHAR(30)
);

CREATE TABLE Rendez_Vous(
    idRendez_vous serial primary key NOT NULL,
    idClient int,
    idService int,
    Dates date,
    Etat int,
    FOREIGN KEY(idClient) REFERENCES Client(idClient),
    FOREIGN KEY(idService) REFERENCES Services(idService)
);

CREATE TABLE Historique_service(
    idHistorique_service serial primary key NOT NULL,
    idService int not null,
    depense int not null,
    Dates date default current_date,
--Entre 0 et 100
    marge int not null,
    nombre int not null,
    finalprice int not null,
    FOREIGN KEY(idService) REFERENCES Services(idService)
);

CREATE TABLE Devis(
    idDevis serial primary key NOT NULL,
    idClient int,
    idService int,
    Remarque text,
    FOREIGN KEY(idClient) REFERENCES Client(idClient),
    FOREIGN KEY (idService) REFERENCES Services(idService)
);

INSERT INTO Genre(nomgenre) VALUES('m'),('f');

INSERT INTO Niveaux(nomniveaux) VALUES
('CEPE'),
('BEPC'),
('BACC'),
('Licence'),
('Master'),
('Doctorat');

INSERT INTO Specialite(nomSpecialite) VALUES
('Détartrage'),
('Extraction dentaire'),
('Netoyage cavitaire'),
('Plombage'),
('Appareillage');

INSERT INTO Services(nomService) VALUES
('Détartrage'),
('Extraction dentaire'),
('Netoyage cavitaire'),
('Plombage'),
('Appareillage');

INSERT INTO Admins(email,passwords) VALUES ('Admin@gmail.com','admin');
---1920
--2082