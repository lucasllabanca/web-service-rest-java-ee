package br.inatel.dm110.supplier.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITING", schema = "public")
public class SupplierAuditing implements Serializable {

	private static final long serialVersionUID = 2190720527963891702L;
		
	public SupplierAuditing() {}
	
	public SupplierAuditing(String cnpj, String operation, LocalDateTime auditingDate) {
		super();
		this.cnpj = cnpj;
		this.operation = operation;
		this.auditingDate = auditingDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "auditingDate")
	private LocalDateTime auditingDate;
	
	public int getId() {
		return id;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public LocalDateTime getAuditingDate() {
		return auditingDate;
	}

	public void setAuditingDate(LocalDateTime auditingDate) {
		this.auditingDate = auditingDate;
	}

	@Override
	public String toString() {
		return "SupplierTO [id=" + id + ", cnpj=" + cnpj + ", operation=" + operation + ", auditingDate=" + auditingDate + "]";
	}
}