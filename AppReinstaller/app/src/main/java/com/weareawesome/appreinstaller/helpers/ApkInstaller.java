package com.weareawesome.appreinstaller.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

public class ApkInstaller {

    public void install(Context cntx, String pathToApk) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(pathToApk)), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        cntx.startActivity(intent);
    }

    public void deinstall(Context cntx, String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + packageName));
        cntx.startActivity(intent);
    }
}
