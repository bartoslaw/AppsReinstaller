package com.weareawesome.appreinstaller.helpers;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import java.io.FileOutputStream;
import java.io.IOException;

import cz.msebera.android.httpclient.Header;

public class ApkDownloader {

    public interface DownloadListener {
        void onDownloaded(String pathToApk);
    }

    public void downloadApk(final Context cntx, final String url, final DownloadListener listener) {
        if(listener == null)
            throw new RuntimeException("Listener can't be null!");
        if(url == null || url.isEmpty())
            throw new RuntimeException("You need to specify url");

        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("", ""); //put here needed auth data but please do not commit this data to repo
        String[] allowedTypes = { ".*" };
        client.get(cntx, url, new BinaryHttpResponseHandler(allowedTypes) {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                //todo we should decide upon what we should name .apk files
                listener.onDownloaded(saveFile(cntx, "filename", binaryData));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
                //todo maybe we should retry?
                Toast.makeText(cntx, "Download failed, please try again.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String saveFile(Context cntx, String fileName, byte[] rawData) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = cntx.openFileOutput(fileName + ".apk", Context.MODE_PRIVATE);
            fileOutputStream.write(rawData);

            fileOutputStream.flush();
            fileOutputStream.close();

            //todo maybe we miss here some kind of null/error check?
            return cntx.getFileStreamPath(fileName + ".apk").getAbsolutePath();
        } catch(IOException e) {
            Toast.makeText(cntx, "Writing file to storage failed.", Toast.LENGTH_LONG).show();
        }

        return "";
    }
}
