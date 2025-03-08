
package com.clients.admin;


import com.provider.attendance.AttendanceTrackingService;
import com.providers.UserService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class AdminDashboard implements BundleActivator {
    private ServiceReference userServiceRef;
    private ServiceReference attendanceServiceRef;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\nAdmin Dashboard Started...");

        // Get service references
        userServiceRef = context.getServiceReference(UserService.class.getName());
        attendanceServiceRef = context.getServiceReference(AttendanceTrackingService.class.getName());

        if (userServiceRef == null) {
            System.out.println("UserService reference not found!");
        }
        if (attendanceServiceRef == null) {
            System.out.println("AttendanceTrackingService reference not found!");
        }

        if (userServiceRef != null && attendanceServiceRef != null) {
            UserService userService = (UserService) context.getService(userServiceRef);
            AttendanceTrackingService attendanceService = (AttendanceTrackingService) context.getService(attendanceServiceRef);

            System.out.println("\n--- User Management ---");
            userService.displayUsers();

            System.out.println("\n--- Attendance Management ---");

            // Mark attendance for some users
            System.out.println("\nMarking attendance...");
            attendanceService.markAttendance("alice@example.com");
            attendanceService.markAttendance("bob@example.com");

            System.out.println("\nDisplaying Attendance Records...");
            attendanceService.displayAttendanceRecords();
        } else {
            System.out.println("Failed to retrieve services.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\nAdmin Dashboard Stopped...");
        if (userServiceRef != null) context.ungetService(userServiceRef);
        if (attendanceServiceRef != null) context.ungetService(attendanceServiceRef);
    }
}