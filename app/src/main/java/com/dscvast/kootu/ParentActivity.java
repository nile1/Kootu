package com.dscvast.kootu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParentActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        TextView food = findViewById(R.id.foodbtn);
        TextView family = findViewById(R.id.familybtn);
        button1=(Button)findViewById(R.id.button1);

        food.setOnClickListener(this);
        family.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent1 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent1);
                return true;
            case R.id.about:
                Intent intent2 = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        Log.i("TAG","1");
        
        if (v.getId() == R.id.foodbtn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.familybtn) {
            Intent intent = new Intent(getApplicationContext(), FamilyActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button1) {
            Log.i("TAG","2");
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:9686567150"));
            Log.i("TAG","3");
            startActivity(callIntent);
            Log.i("TAG","4");
        }
    }
}
