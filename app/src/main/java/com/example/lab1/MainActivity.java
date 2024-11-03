package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPassword;
    private Button btn;
    private TextView txt;

    /**
     * Sets up the user interface for the app and defines the onClick behavior for the button.
     *
     * @param savedInstanceState The current saved state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        txt = findViewById(R.id.textVie);
        btn = findViewById(R.id.but);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Set onClick listener for the button
        btn.setOnClickListener(e -> {
            String password = editTextPassword.getText().toString();

            if (checkPasswordComplexity(password)) {
                txt.setText("Password meets all requirements.");
            } else {
                txt.setText("Password does not meet complexity requirements.");
            }
        });
    }

    /**
     * Checks the complexity of the given password to ensure it has at least 8 characters,
     * one uppercase letter, one lowercase letter, one number, and one special character.
     *
     * @param pw The password string to check.
     * @return True if the password meets the complexity requirements; false otherwise.
     */
    public boolean checkPasswordComplexity(String pw) {
        if (pw.length() < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }

        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) foundUpperCase = true;
            else if (Character.isLowerCase(c)) foundLowerCase = true;
            else if (Character.isDigit(c)) foundNumber = true;
            else if (isSpecialCharacter(c)) foundSpecial = true;
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Missing an uppercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Missing a lowercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Missing a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Missing a special character", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Checks if a character is a special character.
     *
     * @param c The character to check.
     * @return True if the character is a special character; false otherwise.
     */
    public boolean isSpecialCharacter(char c) {
        return "#$%^&*!@?".indexOf(c) != -1;
    }
}
