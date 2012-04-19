create database Tur_Ahenstva;
use Tur_Ahenstva;

  create table ahenstvo
(
	AhenstvoId integer AUTO_INCREMENT not null,
	Nazva_Tur_Ah nvarchar(50) not null,
	Adresa nvarchar(50) not null,
	Imja_Vlas nvarchar(100) not null,
    Tel_nomer varchar(50) not null,
	Fax_nomer varchar(50) not null,
    Clients_nomber varchar(50) not null,
     Ocenka integer not null,

	primary key (AhenstvoId)
);

create table tur
(
	TurId integer AUTO_INCREMENT not null,
    Ahenstvo_Tur integer not null,
	Nazva_turu nvarchar(50) not null,
	Opus_turu nvarchar(100) not null,
	Data_poch_turu nvarchar(50) not null,
    Truv_turu varchar(50) not null,
    Kraina nvarchar(100) not null,
	Vartist varchar(50) not null,

	primary key (TurId)
);

alter table tur
	add constraint FK_Ahenstvo_Tur
	foreign key (Ahenstvo_Tur)
	references ahenstvo(AhenstvoId);