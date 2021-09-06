package br.inatel.dm110.api.supplier;

import java.io.Serializable;
import java.security.Timestamp;

public class SupplierTO implements Serializable {

	private static final long serialVersionUID = -1383046626688436752L;

	private int id;
	private String cnpj;
	private String name;
	private String email;
	private String cep;
	private Timestamp lastPurchase;
	private int rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Timestamp getLastPurchase() {
		return lastPurchase;
	}
	public void setLastPurchase(Timestamp lastPurchase) {
		this.lastPurchase = lastPurchase;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "SupplierTO [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", email=" + email + ", cep=" + cep + ", lastPurchase=" + lastPurchase + ", rating=" + rating + "]";
	}
	
}