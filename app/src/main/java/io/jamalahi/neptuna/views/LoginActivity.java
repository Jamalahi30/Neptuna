package io.jamalahi.neptuna.views;

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
import io.jamalahi.neptuna.presenters.Authentication;
import io.jamalahi.neptuna.presenters.Validator;
import io.jamalahi.neptuna.utils.Messages;
import io.jamalahi.neptuna.utils.Session;

public class LoginActivity extends AppCompatActivity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(getApplicationContext());
        if(session.isActive()){
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
            finish();
        }
        // We link our components
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
               //recuperer login et mot de passe
                String login = ((EditText)findViewById(R.id.login_username)).getText().toString().trim();
                String password = ((EditText)findViewById(R.id.login_password)).getText().toString().trim();
                if(!Validator.validateEmail(login)){
                    Messages.toast(getApplicationContext(),getString(R.string.badEmailFormatAlert));
                    return;
                }

                if(!Validator.validatePassword(password)){
                    Messages.toast(getApplicationContext(),getString(R.string.badPasswordAlert));
                    return;
                }

                User user = Authentication.signIn(new User(login,password));
                if (user == null) {
                    Messages.toast(getApplicationContext(),getString(R.string.login_authFailure));
                    return;
                }
                session.start(user);
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

    }
}
