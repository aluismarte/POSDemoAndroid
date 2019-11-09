package com.alsjava.courses.posdemoandroid.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by aluis on 11/2/19.
 */
public class Constants {

    private static volatile Constants instance = null;

    public static final String SERVER_URL = "http://192.168.0.4:8080/api";

    public static final String SESSION_FORM_RESOURCE = "session";
    public static final String DATA_FORM_RESOURCE = "data";

    private String session = "";

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private Constants() {
    }

    public static Constants get() {
        Constants result = instance;
        if (result == null) {
            synchronized (Constants.class) {
                if (instance == null) {
                    instance = result = new Constants();
                }
            }
        }
        return result;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String stringify(Object object) {
        return this.gson.toJson(object);
    }

    public <T> T convert(String data, Class<T> validClass) {
        if (data != null && !data.isEmpty()) {
            try {
                return this.gson.fromJson(data, validClass);
            } catch (Exception var4) {
                return null;
            }
        } else {
            return null;
        }
    }
}
