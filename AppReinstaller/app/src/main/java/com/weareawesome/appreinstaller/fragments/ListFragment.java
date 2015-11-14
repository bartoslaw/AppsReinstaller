package com.weareawesome.appreinstaller.fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weareawesome.appreinstaller.R;
import com.weareawesome.appreinstaller.models.AppModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private ArrayList<AppModel> populateList() {
        return transformApplicationInfoToAppModel(getAllInstalledApps());
    }

    private List<ApplicationInfo> getAllInstalledApps() {
        return getActivity().getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }

    private ArrayList<AppModel> transformApplicationInfoToAppModel(List<ApplicationInfo> installedAppsList) {
        ArrayList<AppModel> appModelArrayList = new ArrayList<>(installedAppsList.size());
        AppModel model = new AppModel();

        for(ApplicationInfo app : installedAppsList) {
            model.setName(app.name);
            model.setPackageName(app.packageName);
            model.setIcon(app.loadIcon(getActivity().getPackageManager()));

            appModelArrayList.add(model);
        }

        return appModelArrayList;
    }
}
