package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailIcon;
    private TextView detailCategory;
    private TextView detailTitle;
    private TextView detailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });

        // Find views in the detail layout
        detailIcon = findViewById(R.id.detailIcon);
        detailCategory = findViewById(R.id.detailCategory);
        detailTitle = findViewById(R.id.detailTitle);
        detailContent = findViewById(R.id.detailContent);

        // Get category index from MainActivity
        int index = getIntent().getIntExtra(
                "category_index", 0);

        // Load data from arrays.xml
        String[] images = getResources().getStringArray(
                R.array.string_array_images);

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles);

        String[] contents = getResources().getStringArray(
                R.array.string_array_content);

        // Category names
        String[] categories = {
                "Facilities",
                "Events",
                "Clubs",
                "Support"
        };

        // Update category and title
        detailCategory.setText(categories[index]);
        detailTitle.setText(titles[index]);

        // Update detailed content
        detailContent.setText(contents[index]);

        // Get corresponding drawable resource
        String imageName = images[index].trim();

        int imageResource = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        // Update category image
        detailIcon.setImageResource(imageResource);
    }
}
