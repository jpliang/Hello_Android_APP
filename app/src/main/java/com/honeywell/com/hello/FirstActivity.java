package com.honeywell.com.hello;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    public String TAG = "app_debug";
    public PowerManager pm;
    PowerManager.WakeLock wk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button bt1= (Button) findViewById(R.id.button_1);
        Button bt2= (Button) findViewById(R.id.exit_bt);
        bt1.setOnClickListener(new MyToastListener());
        bt2.setOnClickListener(new ExitClickListener());

        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wk = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, TAG);
        wk.acquire();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remov_item:
                Toast.makeText(this, "Remove Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this, "About Me", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private class MyToastListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(FirstActivity.this, "I LOVE U", Toast.LENGTH_SHORT).show();
            //Intent in = new Intent(FirstActivity.this, SecondActivity.class);
            //Intent in = new Intent("jianpengliang");
            //in.addCategory("jpliang");
            Intent in = new Intent(Intent.ACTION_VIEW);
            //in.setData(Uri.parse("http://www.baidu.com"));
            in.setData(Uri.parse("tel:10086"));
            //startActivityForResult(in, 0);
            startActivity(in);
        }
    }

    private class ExitClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            wk.release();
            finish();
        }
    }
}
