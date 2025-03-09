package com.provider.announcementservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class AnnouncementActivator implements BundleActivator {
    private ServiceRegistration announcementServiceReg;

   

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("\n🚀 Announcement Producer Bundle Started...");
        
        AnnouncementService announcementService = new AnnouncementServiceImpl();
        announcementServiceReg = context.registerService(AnnouncementService.class.getName(), announcementService, null);

        System.out.println("✅ Announcement Service Registered!");
    }


    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("\n⏹ Announcement Producer Bundle Stopped...");
        announcementServiceReg.unregister();
    }

}