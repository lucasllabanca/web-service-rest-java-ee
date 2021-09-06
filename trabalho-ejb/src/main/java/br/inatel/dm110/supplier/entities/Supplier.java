package br.inatel.dm110.supplier.entities;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Id;

public class Supplier implements Serializable {

	private static final long serialVersionUID = -5208296043391240977L;
	
	public Supplier() {}
		
	public Supplier(int id, String cnpj, String name, String email, String cep, Timestamp lastPurchase, int rating) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.email = email;
		this.cep = cep;
		this.lastPurchase = lastPurchase;
		this.rating = rating;
	}



	@Id
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