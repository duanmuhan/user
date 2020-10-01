package com.cgs.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class UserIdGenerateUtils {

    private static AtomicInteger id = new AtomicInteger(0);

    private static AtomicInteger IntId = new AtomicInteger(0);

    public static int getUserId(){
        return (int)(System.currentTimeMillis()/1000L & 0xFFFFFFFF << 16 | id.addAndGet(1) & 0xFFFF);
    }

    public static int getInitId(){
        return ((int)(System.currentTimeMillis() - 1000000000000L)/1000)<<16L | (IntId.addAndGet(1));
    }
}
