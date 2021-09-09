package br.inatel.dm110.supplier.beans;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.api.supplier.SupplierTO;
import br.inatel.dm110.supplier.entities.SupplierAuditing;

@Stateless
@Local
public class SupplierAuditingBean {

	private static Logger log = Logger.getLogger(SupplierAuditingBean.class.getName());
	
	@PersistenceContext(unitName = "trabalho_dm110_pu")
	private EntityManager em;
	
	public void auditSupplier(SupplierTO s) {
		
		try {
			
			log.info("AUDITING SUPPLIER: " + s.toString());
			
			SupplierAuditing sAuditing = new SupplierAuditing(s.getCnpj(), "CREATE", LocalDateTime.now());
			
			if (s.getId() > 0) {
				sAuditing.setOperation("UPDATE");
			}
					
			em.persist(sAuditing);
								
			log.info("SUPPLIER: " + sAuditing.toString() + " audited successfully");
			
		} catch (Exception e) {
			log.info("ERROR AUDITING SUPPLIER: " + e.getMessage());
		}
	}
	
}