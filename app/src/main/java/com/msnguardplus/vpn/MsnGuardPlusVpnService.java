package com.msnguardplus.vpn;

import android.content.*; import android.net.VpnService; import android.os.ParcelFileDescriptor; import android.app.*;

public class MsnGuardPlusVpnService extends VpnService {
    private ParcelFileDescriptor tun;
    @Override public int onStartCommand(Intent intent,int flags,int startId){
        // Deliberately do not create a black-hole TUN. The native tunnel must be started first.
        // This prevents the app from cutting off all device traffic until the NativeCore bridge is wired.
        return START_STICKY;
    }
    @Override public void onDestroy(){ try{if(tun!=null)tun.close();}catch(Exception ignored){} super.onDestroy(); }
}
