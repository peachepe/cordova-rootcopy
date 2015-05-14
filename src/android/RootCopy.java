package com.peachepe;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class RootCopy extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("copy")) {
            this.copy(args, callbackContext);
            return true;
        }
        return false;
    }

    private void copy(JSONArray args, CallbackContext callbackContext) {

        try {
            // copy the file
            Process proc = Runtime.getRuntime().exec("su");
            OutputStream os = proc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            dos.writeBytes("cat " +  args.getString(0) + " > " + args.getString(1) + "\n");
            dos.flush();

            dos.writeBytes("chmod 0777 " +  args.getString(1) + "\n");
            dos.flush();

            dos.close();
            proc.waitFor();
            
            callbackContext.success("success");

        } catch (Exception ex) {
            Log.i("RootCopy", "There are no root permissions.", ex);
            callbackContext.error("There are no root permissions.");
        }
    }
}