package domain;

import domain.domainType;

public class Tur extends domainType {
    
	private Integer Ahenstvo_Tur;
	private Integer AhenstvoId;
	private String Nazva_turu;
	private String Opus_turu;
	private String Data_poch_turu;
	private Integer Truv_turu;
	private String Kraina;
	private String Vartist;

	public Integer getAhenstvo_Tur() {
		return Ahenstvo_Tur;
	}

	public void setAhenstvo_Tur(Integer ahenstvo_Tur) {
		this.Ahenstvo_Tur = ahenstvo_Tur;
	}
	
	public String getNazva_turu() {
		return Nazva_turu;
	}

	public void setNazva_turu(String nazva_turu) {
		this.Nazva_turu = nazva_turu;
	}

	public String getOpus_turu() {
		return Opus_turu;
	}

	public void setOpus_turu(String opus_turu) {
		this.Opus_turu = opus_turu;
	}

	public String getData_poch_turu() {
		return Data_poch_turu;
	}

	public void setData_poch_turu(String data_poch_turu) {
		this.Data_poch_turu = data_poch_turu;
	}

	public Integer getTruv_turu() {
		return Truv_turu;
	}

	public void setTruv_turu(Integer truv_turu) {
		this.Truv_turu = truv_turu;
	}

	public String getKraina() {
		return Kraina;
	}

	public void setKraina(String kraina) {
		this.Kraina = kraina;
	}

	public String getVartist() {
		return Vartist;
	}

	public void setVartist(String vartist) {
		this.Vartist = vartist;
	}

	public Integer getAhenstvoId() {
		return AhenstvoId;
	}

	public void setAhenstvoId(Integer ahenstvoId) {
		this.AhenstvoId = ahenstvoId;
	}

}
