package com.msnguardplus.vpn;

import android.app.*; import android.content.*; import android.graphics.Color; import android.net.VpnService; import android.os.*; import android.view.*; import android.widget.*; import java.util.*;

public class MainActivity extends Activity {
    TextView status, count; Button connect;
    @Override public void onCreate(Bundle b){super.onCreate(b); build();}
    void build(){
        LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(36,48,36,36); root.setBackgroundColor(Color.rgb(18,18,18));
        TextView title=t("MSN-GUARD+",28); title.setTextColor(Color.WHITE); root.addView(title);
        status=t("آماده — هستهٔ VPN در حال اتصال به NativeCore است",16); status.setTextColor(Color.LTGRAY); root.addView(status);
        try { int n=ServerRepository.load(this).size(); count=t("تعداد ورودی‌های سرور از APK اصلی: "+n,16); count.setTextColor(Color.GREEN); root.addView(count); } catch(Exception e){}
        connect=new Button(this); connect.setText("اتصال"); root.addView(connect,new LinearLayout.LayoutParams(-1,WRAP_CONTENT));
        TextView info=t("امکانات: انتخاب سرور، Kill Switch، Split Tunnel، تست تأخیر و DNS leak protection\n\nاین نسخه از server_entries.txt و native libraries همان APK مرجع استفاده می‌کند.",15); info.setTextColor(Color.GRAY); root.addView(info);
        connect.setOnClickListener(v -> requestVpn()); setContentView(root);
    }
    TextView t(String s,int z){TextView v=new TextView(this);v.setText(s);v.setTextSize(z);v.setPadding(0,12,0,12);return v;}
    void requestVpn(){Intent i=VpnService.prepare(this); if(i!=null) startActivityForResult(i,7); else startService(new Intent(this,MsnGuardPlusVpnService.class));}
}
