package net.minasamy.reactiveprogrammingdemo.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by mab on 8/15/16.
 */
public class Utils {

    public static List<ApplicationInfo> getAppsList(Context context) {
        final Intent appsIntent = new Intent(Intent.ACTION_MAIN);
        appsIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ApplicationInfo> apps = context.getPackageManager()
                .getInstalledApplications(PackageManager.GET_META_DATA);
        return apps;
    }
}
