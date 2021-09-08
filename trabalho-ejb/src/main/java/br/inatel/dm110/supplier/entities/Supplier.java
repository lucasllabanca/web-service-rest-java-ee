package br.inatel.dm110.supplier.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPLIER", schema = "public")
public class Supplier implements Serializable {

	private static final long serialVersionUID = -5208296043391240977L;
	
	public Supplier() {}
		
	public Supplier(String cnpj, String name, String email, String cep, LocalDateTime lastPurchase, int rating) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.email = email;
		this.cep = cep;
		this.lastPurchase = lastPurchase;
		this.rating = rating;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "lastPurchase")
	private LocalDateTime lastPurchase;
	
	@Column(name = "rating")
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

	public LocalDateTime getLastPurchase() {
		return lastPurchase;
	}

	public void setLastPurchase(LocalDateTime lastPurchase) {
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