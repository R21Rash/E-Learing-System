package com.providers;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("this is rashad testing");
	System.out.println("Final testing commit");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("this is stopped");
	}

}
