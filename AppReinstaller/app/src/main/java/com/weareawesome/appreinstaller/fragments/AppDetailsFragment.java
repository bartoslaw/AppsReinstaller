package com.weareawesome.appreinstaller.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.weareawesome.appreinstaller.R;
import com.weareawesome.appreinstaller.helpers.ApkDownloader;
import com.weareawesome.appreinstaller.helpers.ApkInstaller;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppDetailsFragment extends Fragment {

    public final static String TAG = AppDetailsFragment.class.getSimpleName();

    private ApkInstaller apkInstaller;
    private ApkDownloader apkDownloader;

    @Bind(R.id.fragment_details_url_input)
    EditText urlEditText;

    @OnClick(R.id.fragment_details_install_button)
    public void onReinstallButtonClicked() {
        if (urlEditText.getText().toString().isEmpty())
            Toast.makeText(getActivity(), "You need to specify url.", Toast.LENGTH_SHORT).show();
        else reinstallApp();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVariables();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void initVariables() {
        apkDownloader = new ApkDownloader();
        apkInstaller = new ApkInstaller();

        urlEditText.setText("");
    }

    private void reinstallApp() {
        apkDownloader.downloadApk(getActivity(), urlEditText.getText().toString(), new ApkDownloader.DownloadListener() {
            @Override
            public void onDownloaded(String pathToApk) {
                apkInstaller.install(getActivity(), pathToApk);
            }
        });
    }
}
