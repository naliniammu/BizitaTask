package com.example.bizitatask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.bizitatask.databinding.ActivityProfileDetailsBinding;

public class ProfileDetailsActivity extends AppCompatActivity {
    private ActivityProfileDetailsBinding profileDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile_details);
        final String name = getIntent().getStringExtra("name");
        final String category = getIntent().getStringExtra("category");
        final String address = getIntent().getStringExtra("address");
        final String description = getIntent().getStringExtra("description");
        final String contact = getIntent().getStringExtra("contact");
        final String empcode = getIntent().getStringExtra("empcode");
        final String image = getIntent().getStringExtra("image");

        profileDetailsBinding.profileUserName.setText(name);
        profileDetailsBinding.category.setText(category);
        profileDetailsBinding.address.setText(address);
        profileDetailsBinding.descriprition.setText(description);
        profileDetailsBinding.contactNumber.setText(contact);
        profileDetailsBinding.employeeCode.setText(empcode);
        if (image!= null) {
            Glide.with(this)
                    .load(image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(profileDetailsBinding.profileImage);
        } else {
            profileDetailsBinding.profileImage.setImageDrawable(null);
        }
    }


}
