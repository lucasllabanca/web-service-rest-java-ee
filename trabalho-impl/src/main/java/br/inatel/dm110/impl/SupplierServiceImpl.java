package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.supplier.SupplierService;
import br.inatel.dm110.api.supplier.SupplierTO;
import br.inatel.dm110.interfaces.supplier.SupplierLocal;

@RequestScoped
public class SupplierServiceImpl implements SupplierService {
	
	@EJB
	private SupplierLocal supplierBean;

	@Override
	public String saveSupplier(SupplierTO supplier) {	
		return supplierBean.saveSupplier(supplier);
	}

	@Override
	public SupplierTO getSupplierById(Integer id) {
		return supplierBean.getSupplierById(id);
	}

	@Override
	public SupplierTO getSupplierByCnpj(String cnpj) {
		return supplierBean.getSupplierByCnpj(cnpj);
	}

	@Override
	public List<SupplierTO> listSuppliers() {
		return supplierBean.listSuppliers();
	}

	@Override
	public String updateSupplier(SupplierTO supplier, Integer id) {
		return supplierBean.updateSupplier(supplier, id);
	}

}
