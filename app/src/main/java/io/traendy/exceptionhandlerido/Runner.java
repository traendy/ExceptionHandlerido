package io.traendy.exceptionhandlerido;

import android.os.Looper;

import static android.os.Looper.loop;

public class Runner implements Runnable {

    private final boolean forceNullpointer;
    private final BaseExceptionHandler mExceptionHandler;

    public Runner( boolean forceNullpointer, BaseExceptionHandler exceptionHandler) {
        this.forceNullpointer = forceNullpointer;
        this.mExceptionHandler = exceptionHandler;
    }

    @Override
    public void run() {
        Looper.prepare();
        if(forceNullpointer){
           mExceptionHandler.onExceptionThrown(new NullPointerException("Hello, I am a Nullpointer."));
        }
        loop();
    }
}
