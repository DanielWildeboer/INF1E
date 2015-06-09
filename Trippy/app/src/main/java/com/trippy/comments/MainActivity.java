package com.trippy.comments;

/**
 * Created by School Nieuw on 8-6-2015.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trippy.R;

public class MainActivity extends Activity {


    EditText nameTextField;
    EditText emailTextField;
    EditText messageTextField;
    EditText timeTextField;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        //make name text field object
        nameTextField = (EditText) findViewById(R.id.nameTextField);
        //make email text field object
        emailTextField = (EditText) findViewById(R.id.emailTextField);
        //make message text field object
        messageTextField = (EditText) findViewById(R.id.messageTextField);
        //make time field object
        timeTextField = (EditText) findViewById(R.id.timeTextField);
        //make button object
        sendButton = (Button) findViewById(R.id.sendButton);
    }

    public void send(View v)
    {

        //get name from name box
        String  name = nameTextField.getText().toString();
        //get email from email box
        String  email = emailTextField.getText().toString();
        //get message from message box
        String  msg = messageTextField.getText().toString();
        //get time from time box
        String  time = timeTextField.getText().toString();


        //check whether the msg empty or not
        if(msg.length()>0) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://roebie24.comule.com/commentsapi/insert.php");

            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("id", "01"));
                nameValuePairs.add(new BasicNameValuePair("name", name));
                nameValuePairs.add(new BasicNameValuePair("email", email));
                nameValuePairs.add(new BasicNameValuePair("message", msg));
                nameValuePairs.add(new BasicNameValuePair("time", time));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);
                nameTextField.setText(""); //reset the name text field
                emailTextField.setText(""); //reset the email text field
                messageTextField.setText(""); //reset the message text field
                timeTextField.setText(""); //reset the time text field
                Toast.makeText(getBaseContext(),"Sent",Toast.LENGTH_SHORT).show();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //display message if text field is empty
            Toast.makeText(getBaseContext(),"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }

}

