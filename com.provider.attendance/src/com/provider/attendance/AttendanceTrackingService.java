package com.provider.attendance;

public interface AttendanceTrackingService {
	boolean markAttendance(String email);
    boolean checkAttendance(String email);
    void displayAttendanceRecords();
}
