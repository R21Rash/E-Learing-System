package com.clients;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.providers.UserService;

public class ClientActivator implements BundleActivator {
    private ServiceReference userServiceRef;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\n Client Bundle Started...");

        // Lookup UserService
        userServiceRef = context.getServiceReference(UserService.class.getName());

        if (userServiceRef != null) {
            UserService userService = (UserService) context.getService(userServiceRef);
            System.out.println(" Connected to UserService!");

            // 🔹 Register Users (Testing)
            userService.registerUser("Alice", "alice@example.com", "Student");
            userService.registerUser("Bob", "bob@example.com", "Admin");
            userService.registerUser("Charlie", "charlie@example.com", "Student");

            // 🔹 Display Registered Users
            userService.displayUsers();

            // 🔹 Login Users
            userService.loginUser("alice@example.com", "password");
            userService.loginUser("bob@example.com", "password");

        } else {
            System.out.println(" UserService is NOT available!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\n Client Bundle Stopped...");
        if (userServiceRef != null) {
            context.ungetService(userServiceRef);
        }
    }
}