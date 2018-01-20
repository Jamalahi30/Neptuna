package io.jamalahi.neptuna.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.jamalahi.neptuna.R;
import io.jamalahi.neptuna.database.models.User;

public class LoginActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // We link our components
        final EditText _login_ = findViewById(R.id.login_username);
        final EditText _password_ = findViewById(R.id.login_password);
        TextView _forgottenPassword_= findViewById(R.id.login_forgotten_password);
        Button _signIn_ = findViewById(R.id.login_sign_in);
        TextView _signUp_ = findViewById(R.id.login_sign_up);

        // handle click events
        _forgottenPassword_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RecoverPasswordActivity.class));
            }
        });
        _signUp_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
        _signIn_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User(
                        _login_.getText().toString().trim(),
                        _password_.getText().toString().trim()
                );
                if(! user.isValid()){
                    Toast.makeText(
                            getApplicationContext(),
                            getString(R.string.login_failure),
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }
                Toast.makeText(
                        getApplicationContext(),
                        getString(R.string.login_success),
                        Toast.LENGTH_LONG
                ).show();

            }
        });

    }
}
