package com.example.bizitatask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ProfileDetailsActivity extends AppCompatActivity {

    ImageView profile_image;
    TextView profile_user_name, contact_number, employee_code;
    TextView textcategory, textaddress, descriprition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        final String name = getIntent().getStringExtra("name");
        final String category = getIntent().getStringExtra("category");
        final String address = getIntent().getStringExtra("address");
        final String description = getIntent().getStringExtra("description");
        final String contact = getIntent().getStringExtra("contact");
        final String empcode = getIntent().getStringExtra("empcode");
        final String image = getIntent().getStringExtra("image");

        profile_image = findViewById(R.id.profile_image);
        profile_user_name = findViewById(R.id.profile_user_name);
        contact_number = findViewById(R.id.contact_number);
        employee_code = findViewById(R.id.employee_code);
        textcategory = findViewById(R.id.category);
        textaddress = findViewById(R.id.address);
        descriprition = findViewById(R.id.descriprition);

        profile_user_name.setText(name);
        textcategory.setText(category);
        textaddress.setText(address);
        descriprition.setText(description);
        contact_number.setText(contact);
        employee_code.setText(empcode);
        if (image!= null) {
            Glide.with(this)
                    .load(image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(profile_image);
        } else {
            profile_image.setImageDrawable(null);
        }
    }


}
