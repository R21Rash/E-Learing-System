package com.providers;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class UserManagementService implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("User Management Service Started...");

        // Ensure UserServiceImpl is properly referenced
        UserService userService = new UserServiceImpl(); 
        registration = context.registerService(UserService.class.getName(), userService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("User Management Service Stopped...");
        registration.unregister();
    }
}