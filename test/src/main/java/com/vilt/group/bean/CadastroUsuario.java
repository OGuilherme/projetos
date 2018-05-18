package com.vilt.group.bean;

public class CadastroUsuario {

	private String Name;
	private String FatherName;
	private String MotherName;
	private String Birthday;
	private String CPF;
	private String RG;
	private String UF_CNH;
	private String ExpeditionDateCNH;
	private String ExpirationDateCNH;
	private String Address;
	private String CEP;
	private String City;
	private String State;
	private String BillExpirationDate;
	private String BillExpeditionDate;

	public CadastroUsuario() {
		super();
	}

	public CadastroUsuario(String name, String fatherName, String motherName, String birthday, String cPF, String rG,
			String uF_CNH, String expeditionDateCNH, String expirationDateCNH, String address, String cEP, String city,
			String state, String billExpirationDate, String billExpeditionDate) {
		super();
		Name = name;
		FatherName = fatherName;
		MotherName = motherName;
		Birthday = birthday;
		CPF = cPF;
		RG = rG;
		UF_CNH = uF_CNH;
		ExpeditionDateCNH = expeditionDateCNH;
		ExpirationDateCNH = expirationDateCNH;
		Address = address;
		CEP = cEP;
		City = city;
		State = state;
		BillExpirationDate = billExpirationDate;
		BillExpeditionDate = billExpeditionDate;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getMotherName() {
		return MotherName;
	}

	public void setMotherName(String motherName) {
		MotherName = motherName;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getUF_CNH() {
		return UF_CNH;
	}

	public void setUF_CNH(String uF_CNH) {
		UF_CNH = uF_CNH;
	}

	public String getExpeditionDateCNH() {
		return ExpeditionDateCNH;
	}

	public void setExpeditionDateCNH(String expeditionDateCNH) {
		ExpeditionDateCNH = expeditionDateCNH;
	}

	public String getExpirationDateCNH() {
		return ExpirationDateCNH;
	}

	public void setExpirationDateCNH(String expirationDateCNH) {
		ExpirationDateCNH = expirationDateCNH;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getBillExpirationDate() {
		return BillExpirationDate;
	}

	public void setBillExpirationDate(String billExpirationDate) {
		BillExpirationDate = billExpirationDate;
	}

	public String getBillExpeditionDate() {
		return BillExpeditionDate;
	}

	public void setBillExpeditionDate(String billExpeditionDate) {
		BillExpeditionDate = billExpeditionDate;
	}
}