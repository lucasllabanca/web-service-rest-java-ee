package br.inatel.dm110.interfaces.supplier;

import java.util.List;

import br.inatel.dm110.api.supplier.SupplierTO;

public interface Supplier {
	
	String saveSupplier(SupplierTO supplier);
	
	SupplierTO getSupplierById(Integer id);
	
	SupplierTO getSupplierByCnpj(String cnpj);
	
	List<SupplierTO> listSuppliers();
	
	String updateSupplier(SupplierTO supplier);

}