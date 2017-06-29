package kr.co.tmon.hunjin.simpledairy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ysg01129 on 2017-06-29.
 */

public class GetCurrentDateTime {
    // 현재시간을 msec 으로 구한다.

    public static String getCurrentDateTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = sdfNow.format(date);

        return formatDate;
    }


}
