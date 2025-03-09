package com.provider.announcementservice;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    private List<String> announcements = new ArrayList<>();

    @Override
    public void postAnnouncement(String message) {
        announcements.add(message);
        System.out.println("📢 New Announcement Added: " + message);
    }

    @Override
    public void displayAnnouncements() {
        System.out.println("\n📜 Current Announcements:");
        if (announcements.isEmpty()) {
            System.out.println("No announcements available.");
        } else {
            for (String announcement : announcements) {
                System.out.println("- " + announcement);
            }
        }
    }
}
