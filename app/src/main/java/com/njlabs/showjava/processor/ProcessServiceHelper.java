package com.njlabs.showjava.processor;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.njlabs.showjava.utils.ExceptionHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

@SuppressWarnings("unused")
class ProcessServiceHelper {

    ProcessService processService;
    Handler UIHandler;
    String packageFilePath;
    String packageName;
    String sourceOutputDir;
    String javaSourceOutputDir;
    ExceptionHandler exceptionHandler;
    PrintStream printStream = null;

    void broadcastStatus(String status) {
        processService.broadcastStatus(status);
    }

    void broadcastStatus(String statusKey, String statusData) {
        processService.broadcastStatus(statusKey, statusData);
    }

    public void broadcastStatusWithPackageInfo(String statusKey, String dir, String packId) {
        processService.broadcastStatusWithPackageInfo(statusKey, dir, packId);
    }

    class ToastRunnable implements Runnable {

        String mText;

        ToastRunnable(String text) {
            mText = text;
        }

        @Override
        public void run() {
            Toast.makeText(processService.getApplicationContext(), mText, Toast.LENGTH_SHORT).show();
        }
    }

    class ProgressStream extends OutputStream {
        ProgressStream() {}

        public void write(@NonNull byte[] data, int i1, int i2) {
            String str = new String(data).trim();
            str = str.replace("\n", "").replace("\r", "");
            str = str.replace("INFO:", "").replace("ERROR:", "").replace("WARN:","");
            str = str.replace("\n\r", "");
            str = str.replace("... done", "").replace("at","");
            str = str.trim();
            if (!str.equals("")) {
                Log.i("PS",str);
                broadcastStatus("progress_stream", str);
            }
        }

        @Override
        public void write(int arg0) throws IOException {}
    }
}
