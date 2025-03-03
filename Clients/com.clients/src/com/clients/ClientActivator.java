package com.clients;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.providers.UserService;

public class ClientActivator implements BundleActivator {
    private ServiceReference userServiceRef;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Client Bundle Started...");

        // Lookup the service
        userServiceRef = context.getServiceReference(UserService.class.getName());

        if (userServiceRef != null) {
            UserService userService = (UserService) context.getService(userServiceRef);
            System.out.println("Connected to UserService!");
            userService.registerUser("Alice", "alice@example.com");  // Test service call
        } else {
            System.out.println("UserService is not available!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Client Bundle Stopped...");
        context.ungetService(userServiceRef);
    }
}
