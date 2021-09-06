package br.inatel.dm110.supplier.beans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.api.supplier.SupplierTO;
import br.inatel.dm110.interfaces.supplier.SupplierLocal;

@Stateless
@Local(SupplierLocal.class)
public class SupplierBean implements SupplierLocal {
	
	private static Logger log = Logger.getAnonymousLogger(SupplierBean.class.getName());
	
	@PersistenceContext(unitName = "supplier_pu")
	private EntityManager em;

	@Override
	public String saveSupplier(SupplierTO supplier) {
		log.info("Saving supplier: " + supplier.toString());
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSupplier(SupplierTO supplier) {
		// TODO Auto-generated method stub
		return null;
	}

}
