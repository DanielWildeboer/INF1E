package com.example.jorrit.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Home extends ActionBarActivity {

    private static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addListenerOnButton();
    }

    //Next page
    public void addListenerOnButton()
    {
        button = (Button)findViewById(R.id.button_snd);
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent("com.example.jorrit.navigationdrawer.NavigationDrawerFragment");
                startActivity(intent);
            }
        });
    }

}
