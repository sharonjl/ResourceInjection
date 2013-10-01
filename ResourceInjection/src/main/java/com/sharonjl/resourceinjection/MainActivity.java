package com.sharonjl.resourceinjection;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.sharonjl.resourceinjectionlibrary.FromResource;
import com.sharonjl.resourceinjectionlibrary.ResourceInjection;

public class MainActivity extends Activity {

    @FromResource(R.string.hello_world)
    String helloString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResourceInjection.inject(this, this, null);

        Log.d("ResourceInjection", helloString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
