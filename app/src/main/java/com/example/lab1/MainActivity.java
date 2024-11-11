package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the main activity for the Password Checker application.
 * It checks the complexity of a password to ensure it meets specified requirements.
 *
 * @author [Your Name]
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * EditText field for entering the password.
     */
    private EditText passwordEditText;

    /**
     * TextView for displaying the result of the password check.
     */
    private TextView resultTextView;

    /**
     * Button to submit the password for validation.
     */
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        passwordEditText = findViewById(R.id.editTextPassword);
        resultTextView = findViewById(R.id.textViewResult);
        loginButton = findViewById(R.id.buttonLogin);

        // Set the button's onClick listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                if (checkPasswordComplexity(password)) {
                    resultTextView.setText("Your password meets the requirements.");
                } else {
                    resultTextView.setText("You shall not pass!");
                }
            }
        });
    }

    /**
     * Checks if the provided password meets the complexity requirements.
     * The password must contain at least one uppercase letter, one lowercase letter,
     * one digit, one special character, and be at least 8 characters long.
     *
     * @param pw The password string to be checked.
     * @return true if the password meets all complexity requirements; false otherwise.
     */
    boolean checkPasswordComplexity(String pw) {
        if (pw.length() < 8) {
            Toast.makeText(this, "Your password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }

        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Your password does not have an uppercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Your password does not have a lowercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Your password does not have a digit", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Your password does not have a special character", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Checks if a character is a special character from the set #$%^&*!@?
     *
     * @param c The character to check.
     * @return true if the character is a special character; false otherwise.
     */
    private boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}
