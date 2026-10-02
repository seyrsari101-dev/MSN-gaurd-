package com.msnguardplus.vpn;

import android.content.Context;
import java.io.*;
import java.util.*;

public final class ServerRepository {
    public static List<String> load(Context c) throws IOException {
        ArrayList<String> out = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(c.getAssets().open("server_entries.txt")))) {
            String line; while ((line = r.readLine()) != null) { line=line.trim(); if(!line.isEmpty()) out.add(line); }
        }
        return out;
    }
}
