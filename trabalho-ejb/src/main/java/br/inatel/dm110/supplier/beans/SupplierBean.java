package br.inatel.dm110.supplier.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.dm110.api.supplier.SupplierTO;
import br.inatel.dm110.interfaces.supplier.SupplierLocal;
import br.inatel.dm110.supplier.entities.Supplier;

@Stateless
@Local(SupplierLocal.class)
public class SupplierBean implements SupplierLocal {
	
	private static Logger log = Logger.getLogger(SupplierBean.class.getName());
	
	@PersistenceContext(unitName = "trabalho_dm110_pu")
	private EntityManager em;

	@Override
	public String saveSupplier(SupplierTO s) {
		
		try {
			
			log.info("ADDING SUPPLIER: " + s.toString());
					
			Supplier supplier = new Supplier(s.getCnpj(), s.getName(), s.getEmail(), s.getCep(), s.getLastPurchase(), s.getRating()); 					
			em.persist(supplier);
								
			return "SUPPLIER: " + supplier.getName() + " - CNPJ: " + supplier.getCnpj() + " saved successfully";
			
		} catch (Exception e) {
			log.info("ERROR SAVING SUPPLIER: " + e.getMessage());
			return e.getMessage();
		}
	}

	@Override
	public SupplierTO getSupplierById(Integer id) {
		
		log.info("GETTING SUPPLIER BY ID: " + id);
			
		TypedQuery<Supplier> query = em.createQuery("select s from Supplier s where s.id= :id", Supplier.class);
		query.setParameter("id", id);
		List<Supplier> supplierList = query.getResultList();
		List<SupplierTO> supplierToList = toCollectionAPIModel(supplierList);
			
		if (supplierToList.isEmpty()) {
			return null;
		} else {
			return supplierToList.get(0);
		}
					
	}

	@Override
	public SupplierTO getSupplierByCnpj(String cnpj) {
		
		log.info("GETTING SUPPLIER BY CNPJ: " + cnpj);
		
		if (cnpj.length() < 14) {
			return null;
		}

		String cnpjFixed = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
		
		TypedQuery<Supplier> query = em.createQuery("select s from Supplier s where s.cnpj= :cnpj", Supplier.class);
		query.setParameter("cnpj", cnpjFixed);
		List<Supplier> supplierList = query.getResultList();
		List<SupplierTO> supplierToList = toCollectionAPIModel(supplierList);
			
		if (supplierToList.isEmpty()) {
			return null;
		} else {
			return supplierToList.get(0);
		}
		
	}

	@Override
	public List<SupplierTO> listSuppliers() {
		
		log.info("GETTING LIST OF SUPPLIERS");
		
		TypedQuery<Supplier> query = em.createQuery("from Supplier s", Supplier.class);
		List<Supplier> supplierList = query.getResultList();		
		
		return toCollectionAPIModel(supplierList); //converte de Entity para API	
		
	}

	@Override
	public String updateSupplier(SupplierTO s, Integer id) {
		
		try {
			
			log.info("UPDATING SUPPLIER: " + s.toString());
			
			Supplier supplier = em.find(Supplier.class, id);
			
			if (supplier == null) {
				return null;
			}
			
			if (s.getId() != id) {
				return null;
			}
			
			supplier.setCnpj(s.getCnpj());
			supplier.setName(s.getName());
			supplier.setEmail(s.getEmail());
			supplier.setCep(s.getCep());
			supplier.setLastPurchase(s.getLastPurchase());
			supplier.setRating(s.getRating());
			 
			em.merge(supplier);
			 
			return "SUPPLIER: " + supplier.getName() + " - CNPJ: " + supplier.getCnpj() + " updated successfully";				
			
		} catch (Exception e) {
			log.info("ERROR UPDATING SUPPLIER: " + e.getMessage());
			return e.getMessage();
		}
		
	}
	
	private List<SupplierTO> toCollectionAPIModel(List<Supplier> supplierList) {
		return supplierList.stream().map(s -> {
			SupplierTO st = new SupplierTO();
			st.setId(s.getId());
			st.setCnpj(s.getCnpj());
			st.setName(s.getName());
			st.setEmail(s.getEmail());
			st.setCep(s.getCep());
			st.setLastPurchase(s.getLastPurchase());
			st.setRating(s.getRating());
			return st;
		}).collect(Collectors.toList());
	}

}