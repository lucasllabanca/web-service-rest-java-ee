package br.inatel.dm110.beans.auditing;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.dm110.api.supplier.SupplierTO;
import br.inatel.dm110.supplier.beans.SupplierAuditingBean;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", 
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", 
								  propertyValue = "java:/jms/queue/trabalhodm110queue") })

@RequestScoped
public class SupplierAuditingQueueMDB implements MessageListener {
	
	@EJB
	private SupplierAuditingBean supplierAuditingBean;

	private static Logger log = Logger.getLogger(SupplierAuditingQueueMDB.class.getName());
	
	@Override
	public void onMessage(Message message) {
		
		try {
			
			if (message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage) message;
				Object object = objMsg.getObject();
								
				if (object instanceof SupplierTO) {
					
					SupplierTO s = (SupplierTO) object;
					
					supplierAuditingBean.auditSupplier(s);
					
					log.info("AUDITING MESSAGE RECEIVED: " + s.toString());
				}
							
			}
		
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}