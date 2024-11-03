package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.R;

/**
 * MainActivity class for the password checker app.
 *
 * This app checks the complexity of passwords based on specified criteria.
 *
 * @author Parvathi Nair
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private EditText editTextPassword; // Input field for password
    private Button btn; // Button to trigger password check
    private TextView txt; // TextView to display results

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.recyclerview.R.layout.activity_main);

        // Initialize views
        txt = findViewById(R.id.textVie);
        btn = findViewById(com.example.recyclerview.R.id.but);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Set onClick listener for the button
        btn.setOnClickListener(e -> {
            String password = editTextPassword.getText().toString();

            boolean isValid = checkPasswordComplexity(password);
            if (isValid) {
                txt.setText("Your password meets the requirements.");
            } else {
                txt.setText("You shall not pass!");
            }
        });
    }

    /**
     * Checks the complexity of a password.
     *
     * @param pw the password to check
     * @return true if the password meets all complexity requirements, false otherwise
     */
    public boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        if (pw.length() < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long.", Toast.LENGTH_SHORT).show();
            return false;
        }

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) foundUpperCase = true;
            if (Character.isLowerCase(c)) foundLowerCase = true;
            if (Character.isDigit(c)) foundNumber = true;
            if (isSpecialCharacter(c)) foundSpecial = true;
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Your password does not have an upper case letter.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!foundLowerCase) {
            Toast.makeText(this, "Your password does not have a lower case letter.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!foundNumber) {
            Toast.makeText(this, "Your password does not have a number.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!foundSpecial) {
            Toast.makeText(this, "Your password does not have a special symbol.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true; // All checks passed
    }

    /**
     * Checks if a character is a special character.
     *
     * @param c the character to check
     * @return true if the character is a special character, false otherwise
     */
    public boolean isSpecialCharacter(char c) {
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
