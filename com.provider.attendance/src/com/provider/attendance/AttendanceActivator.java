package com.provider.attendance;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AttendanceActivator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\nAttendance Service Started...");

        AttendanceTrackingService service = new AttendanceTrackingServiceImpl();
        registration = context.registerService(AttendanceTrackingService.class.getName(), service, null);
        System.out.println("AttendanceTrackingService registered successfully.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\nAttendance Service Stopped...");
        if (registration != null) {
            registration.unregister();
            System.out.println("AttendanceTrackingService unregistered.");
        }
    }
}
