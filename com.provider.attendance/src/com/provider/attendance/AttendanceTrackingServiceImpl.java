package com.provider.attendance;



import java.util.HashMap;
import java.util.Map;

public class AttendanceTrackingServiceImpl implements AttendanceTrackingService {
    private static Map<String, Boolean> attendanceRecords = new HashMap<>();

    @Override
    public boolean markAttendance(String email) {
        if (attendanceRecords.containsKey(email)) {
            System.out.println("Attendance already marked for " + email);
            return false;
        }

        attendanceRecords.put(email, true);
        System.out.println("Attendance marked for " + email);
        return true;
    }

    @Override
    public boolean checkAttendance(String email) {
        return attendanceRecords.getOrDefault(email, false);
    }

    @Override
    public void displayAttendanceRecords() {
        System.out.println("\nAttendance Records:");
        if (attendanceRecords.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            attendanceRecords.forEach((email, status) -> 
                System.out.println("- " + email + ": " + (status ? "Present" : "Absent"))
            );
        }

    }
}