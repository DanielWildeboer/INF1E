package com.trippy.comments;

/**
 * Created by School Nieuw on 8-6-2015.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.trippy.R;

public class AddComment extends Activity {

    // Progress Dialog
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText inputName;
    EditText inputEmail;
    EditText inputMessage;

    // url to create new product
    private static String url_create_product = "http://roebie24.comule.com/commentsapi/insert.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        // Edit Text
        inputName = (EditText) findViewById(R.id.inputName);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputMessage = (EditText) findViewById(R.id.inputMessage);

        // Create button
        Button btnAddMessage = (Button) findViewById(R.id.btnAddMessage);

        // button click event
        btnAddMessage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new product in background thread
                new CreateNewComment().execute();
            }
        });
    }

    /**
     * Background Async Task to Create new product
     * */
    class CreateNewComment extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AddComment.this);
            pDialog.setMessage("Adding comment...");
            pDialog.show();
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.dismiss();
        }

        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {
            String namestr = inputName.getText().toString();
            String emailstr = inputEmail.getText().toString();
            String messagestr = inputMessage.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("name", namestr));
            params.add(new BasicNameValuePair("email", emailstr));
            params.add(new BasicNameValuePair("message", messagestr));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                    "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), AllComments.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}