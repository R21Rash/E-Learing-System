package com.providers;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class UserManagementService implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\n User Management Service Started...");

        // Create service instance
        UserService userService = new UserServiceImpl();
        
        // Register service
        registration = context.registerService(UserService.class.getName(), userService, null);
        System.out.println(" UserService registered successfully.");
    }
    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\n User Management Service Stopped...");
        if (registration != null) {
            registration.unregister();
            System.out.println(" UserService unregistered.");
        }
    }
}