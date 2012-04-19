package domain;

import domain.domainType;

public class Ahenstvo extends domainType {
	
	public static final String Ocenka1 = "1";
	public static final String Ocenka2 = "2";
	public static final String Ocenka3 = "3";
	public static final String Ocenka4 = "4";
	public static final String Ocenka5 = "5";  

	private String Nazva_Tur_Ah;
	private String Adresa;
	private String Imja_Vlas;
	private Integer Tel_nomer;
	private Integer Fax_nomer;
	private Integer Clients_nomber;
	private String Ocenka;

	public String getNazva_Tur_Ah() {
		return Nazva_Tur_Ah;
	}

	public void setNazva_Tur_Ah(String nazva_Tur_Ah) {
		Nazva_Tur_Ah = nazva_Tur_Ah;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public String getImja_Vlas() {
		return Imja_Vlas;
	}

	public void setImja_Vlas(String imja_Vlas) {
		Imja_Vlas = imja_Vlas;
	}

	public Integer getTel_nomer() {
		return Tel_nomer;
	}

	public void setTel_nomer(Integer tel_nomer) {
		Tel_nomer = tel_nomer;
	}

	public Integer getFax_nomer() {
		return Fax_nomer;
	}

	public void setFax_nomer(Integer fax_nomer) {
		Fax_nomer = fax_nomer;
	}

	public Integer getClients_nomber() {
		return Clients_nomber;
	}

	public void setClients_nomber(Integer clients_nomber) {
		Clients_nomber = clients_nomber;
	}
	public String getOcenka() {
		return Ocenka;
	}

	public void setOcenka(String ocenka) {
		Ocenka = ocenka;
	}
}
