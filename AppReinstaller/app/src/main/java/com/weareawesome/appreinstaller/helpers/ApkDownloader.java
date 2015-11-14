package com.weareawesome.appreinstaller.helpers;

public class ApkDownloader {
    public interface DownloadListener {
        void onDownloaded(String pathToApk);
    }

    public void downloadApk(String url, DownloadListener listener) {
        //todo invoke asynchronous download of the apk from given url then invoke listener.onDownloaded(path);
    }
}
