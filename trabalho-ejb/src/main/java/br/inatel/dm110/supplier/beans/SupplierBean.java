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
			
			Supplier supplier = new Supplier(s.getCnpj(), s.getName(), s.getEmail(), s.getCep(), s.getLastPurchase(), s.getRating()); 	
			em.persist(supplier);
			log.info("SAVING SUPPLIER: " + supplier.toString());
			return "SUPPLIER: " + supplier.getName() + " - CNPJ: " + supplier.getCnpj() + " saved successfully";
			
		} catch (Exception e) {
			log.info("ERROR SAVING SUPPLIER: " + e.getMessage());
			return e.getMessage();
		}
	}

	@Override
	public SupplierTO getSupplierById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierTO getSupplierByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierTO> listSuppliers() {
		TypedQuery<Supplier> query = em.createQuery("from Supplier s", Supplier.class);
		List<Supplier> supplierList = query.getResultList();
		return toCollectionAPIModel(supplierList); //converte de Entity para API
	}

	@Override
	public String updateSupplier(SupplierTO supplier) {
		// TODO Auto-generated method stub
		return null;
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