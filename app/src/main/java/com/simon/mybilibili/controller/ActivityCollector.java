package com.simon.mybilibili.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * activity管理器
 * 方便管理Activity的添加,删除和一键退出程序
 * Created by simon on 2017/5/17.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
