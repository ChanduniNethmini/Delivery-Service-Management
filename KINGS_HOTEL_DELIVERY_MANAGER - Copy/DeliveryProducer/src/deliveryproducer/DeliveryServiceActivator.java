package deliveryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DeliveryServiceActivator implements BundleActivator {

//	private static BundleContext context;
//
//	static BundleContext getContext() {
//		return context;
//	}
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Delivery Publisher start");
		DeliveryServicePublish deliveryservicepublish = new DeliveryServicePublishImpl();
		publishServiceRegistration = context.registerService(
				DeliveryServicePublish.class.getName(), deliveryservicepublish, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Delivery Publisher stop");
		publishServiceRegistration.unregister();
	}

}
