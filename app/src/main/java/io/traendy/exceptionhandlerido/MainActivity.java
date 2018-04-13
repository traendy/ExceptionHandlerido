package io.traendy.exceptionhandlerido;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements BaseExceptionHandler, View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onExceptionThrown(Throwable e) {
        Log.e(TAG, e.getMessage());
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_announcement_green_a700_24dp);
        builder.setMessage(e.getMessage());
        builder.setTitle("Wow such a throw.");
        dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:{
                Thread t = new Thread(new Runner(true, this));
                t.start();
            }
        }
    }
}
