
package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnFacilities;
    private ImageButton btnEvents;
    private ImageButton btnClubs;
    private ImageButton btnSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });

        // Find the four ImageButtons
        btnFacilities = findViewById(R.id.btnFacilities);
        btnEvents = findViewById(R.id.btnEvents);
        btnClubs = findViewById(R.id.btnClubs);
        btnSupport = findViewById(R.id.btnSupport);

        // Facilities button click
        btnFacilities.setOnClickListener(v -> {
            Toast.makeText(this, "Facilities clicked",
                    Toast.LENGTH_SHORT).show();
        });

        // Events button click
        btnEvents.setOnClickListener(v -> {
            Toast.makeText(this, "Events clicked",
                    Toast.LENGTH_SHORT).show();
        });

        // Clubs button click
        btnClubs.setOnClickListener(v -> {
            Toast.makeText(this, "Clubs clicked",
                    Toast.LENGTH_SHORT).show();
        });

        // Support button click
        btnSupport.setOnClickListener(v -> {
            Toast.makeText(this, "Support clicked",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
