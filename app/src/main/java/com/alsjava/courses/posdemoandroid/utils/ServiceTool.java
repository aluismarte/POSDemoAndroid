package com.alsjava.courses.posdemoandroid.utils;

import com.alsjava.courses.posdemoandroid.model.CallBack;
import com.alsjava.courses.posdemoandroid.model.communication.request.LoginRequest;
import com.alsjava.courses.posdemoandroid.model.communication.request.ProductRequest;
import com.alsjava.courses.posdemoandroid.model.communication.response.LoginResponse;
import com.alsjava.courses.posdemoandroid.model.communication.response.ProductResponse;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by aluis on 11/9/19.
 */
public class ServiceTool {

    private static volatile ServiceTool instance = null;

    private OkHttpClient okHttpClient = new OkHttpClient();

    private ServiceTool() {
    }

    public static ServiceTool get() {
        ServiceTool result = instance;
        if (result == null) {
            synchronized (ServiceTool.class) {
                if (instance == null) {
                    instance = result = new ServiceTool();
                }
            }
        }
        return result;
    }

    public void login(LoginRequest loginRequest, final CallBack<LoginResponse> callBack) {
        FormBody.Builder builder = new FormBody.Builder()
                .add(Constants.SESSION_FORM_RESOURCE, Constants.get().getSession())
                .add(Constants.DATA_FORM_RESOURCE, Constants.get().stringify(loginRequest));
        Request request = new Request.Builder()
                .url(Constants.SERVER_URL + "/login")
                .post(builder.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody body = response.body();
                if (body != null) {
                    LoginResponse convert = Constants.get().convert(body.string(), LoginResponse.class);
                    callBack.onResult(convert);
                } else {
                    callBack.onResult(null);
                }
            }
        });
    }

    public void products(ProductRequest productRequest, final CallBack<ProductResponse> callBack) {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("192.168.0.4")
                .port(8080)
                .addPathSegments("/api/products")
                .addQueryParameter(Constants.SESSION_FORM_RESOURCE, Constants.get().getSession())
                .addQueryParameter(Constants.DATA_FORM_RESOURCE, Constants.get().stringify(productRequest))
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody body = response.body();
                if (body != null) {
                    ProductResponse convert = Constants.get().convert(body.string(), ProductResponse.class);
                    callBack.onResult(convert);
                } else {
                    callBack.onResult(null);
                }
            }
        });
    }
}
