package com.alsjava.courses.posdemoandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by aluis on 11/16/19.
 */
public class NetworkTool {


    private static NetworkTool instance = null;

    private final Queue<NetworkListener> networkListeners = new ConcurrentLinkedQueue<>();

    private static boolean connected = false;

    private NetworkTool() {
    }

    public static NetworkTool get() {
        NetworkTool result = instance;
        if (result == null) {
            synchronized (NetworkTool.class) {
                if (instance == null) {
                    instance = result = new NetworkTool();
                }
            }
        }
        return result;
    }

    public void prepare(Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() {

                @Override
                public void onAvailable(@NotNull Network network) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null) {
                        connected = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
                    } else {
                        connected = false;
                    }
                    fireNetworkListener(connected);
                }

                @Override
                public void onLost(@NotNull Network network) {
                    connected = false;
                    fireNetworkListener(false);
                }
            });
        }
    }

    private synchronized void fireNetworkListener(boolean state) {
        List<NetworkListener> toDelete = new ArrayList<>();
        for (NetworkListener networkListener : networkListeners) {
            try {
                networkListener.onChange(state);
            } catch (Exception ignored) {
                toDelete.add(networkListener);
            }
        }
        networkListeners.removeAll(toDelete);
    }

    public static boolean isConnected() {
        return connected;
    }

    public void removeNetworkListener(NetworkListener networkListener) {
        networkListeners.remove(networkListener);
    }

    public void addNetworkListener(NetworkListener networkListener) {
        networkListeners.add(networkListener);
    }

    public interface NetworkListener {
        void onChange(boolean state);
    }
}
