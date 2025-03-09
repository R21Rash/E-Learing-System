package com.clients.announcementclient;


import org.osgi.framework.BundleContext;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.provider.announcementservice.AnnouncementService;


public class AnnouncementClientActivator implements BundleActivator {
    private ServiceReference announcementServiceRef;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\n Student Dashboard (Consumer) Bundle Started...");

        // Lookup AnnouncementService
        announcementServiceRef = context.getServiceReference(AnnouncementService.class.getName());

        if (announcementServiceRef != null) {
            AnnouncementService announcementService = (AnnouncementService) context.getService(announcementServiceRef);
            System.out.println(" Connected to AnnouncementService!");

            // 🔹 Post Announcements (Admin Role)
            announcementService.postAnnouncement("Mid-Term Exam on 15th March!");
            announcementService.postAnnouncement("Assignment Submission Deadline: 20th March!");

            // 🔹 Display Announcements (Students)
            announcementService.displayAnnouncements();
        } else {
            System.out.println(" AnnouncementService is NOT available!");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\n Student Dashboard (Consumer) Bundle Stopped...");
        if (announcementServiceRef != null) {
            context.ungetService(announcementServiceRef);
        }
    }
}