package com.example.cylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin, buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignup = findViewById(R.id.buttonSignup);

        // Set up the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Set up the signup button
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
        startActivity(intent);

        // Basic input validation (you can expand this)
//        if (email.isEmpty() || password.isEmpty()) {
//            Toast.makeText(LoginActivity.this, "Please enter both email and password.", Toast.LENGTH_SHORT).show();
//            return;
//        }

//        String url = "http://coms-3090-065.class.las.iastate.edu:8080/users/login";  // Update this with the correct login endpoint
//
//        // Create the request body
//        JSONObject jsonBody = new JSONObject();
//        try {
//            jsonBody.put("email", email);
//            jsonBody.put("password", password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Send POST request to the backend
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                Request.Method.POST,
//                url,
//                jsonBody,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // Debug the API response
//                        Log.d("API Response", response.toString());
//
//                        // Check the response for successful login
//                        boolean success = response.optBoolean("success", false); // Assuming the backend sends a "success" field
//                        if (success) {
//                            String studentName = response.optString("studentName"); // Get student name from response
//                            Toast.makeText(LoginActivity.this, "Welcome " + studentName, Toast.LENGTH_SHORT).show();
//
//                            // Redirect to Welcome Activity (you could pass user data through Intent if needed)
//                            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
//                            startActivity(intent);
//                        } else {
//                            // Handle unsuccessful login, show a toast
//                            String errorMessage = response.optString("message", "Login failed");
//                            Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle errors like network issues, server down, etc.
//                        Toast.makeText(LoginActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        // Add the request to the RequestQueue
//        Volley.newRequestQueue(this).add(jsonObjectRequest);
//    }
    }
}