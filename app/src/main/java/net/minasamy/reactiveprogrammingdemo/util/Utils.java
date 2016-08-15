package net.minasamy.reactiveprogrammingdemo.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import net.minasamy.reactiveprogrammingdemo.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mab on 8/15/16.
 */
public class Utils {

    public static List<AppInfo> getAppsList(Context context) {
        List<AppInfo> apps = new ArrayList<>();
        final Intent appsIntent = new Intent(Intent.ACTION_MAIN);
        appsIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = context.getPackageManager()
                .queryIntentActivities(appsIntent, PackageManager.MATCH_ALL);
        for(ResolveInfo info:resolveInfos){
            Drawable logo=info.loadIcon(context.getPackageManager());
            String label=info.loadLabel(context.getPackageManager()).toString();

            apps.add(new AppInfo(logo,label));
        }
        return apps;
    }
}
