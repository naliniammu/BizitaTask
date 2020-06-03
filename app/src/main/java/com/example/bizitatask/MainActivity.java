package com.example.bizitatask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.bizitatask.adapter.ProfileListAdapter;
import com.example.bizitatask.databinding.ActivityMainBinding;
import com.example.bizitatask.entities.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ProfileListAdapter.OnItemclickListner {
   private ActivityMainBinding activityMainBinding;
    private ProfileListAdapter profileListAdapter;
    private ProfileListAdapter.OnItemclickListner onItemclickListner;
    private List<Profile> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        onItemclickListner = this;
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        activityMainBinding.profileListRecyclerView.setLayoutManager(mLayoutManager);
        loadProfiledata();
    }

    @Override
    public void onItemClick(int status, int position) {
        if (status == 1) {
            String profilename = articleList.get(position).getAddress();
            String category = articleList.get(position).getCategory();
            String address = articleList.get(position).getAddress();
            String description = articleList.get(position).getDescription();
            String contact = articleList.get(position).getContact();
            String empcode = articleList.get(position).getEmpcode();
            String image = articleList.get(position).getImage();
            if (!TextUtils.isEmpty(profilename)) {
                Intent detailsActivity = new Intent(MainActivity.this, ProfileDetailsActivity.class);
                detailsActivity.putExtra("name", profilename);
                detailsActivity.putExtra("category", category);
                detailsActivity.putExtra("address", address);
                detailsActivity.putExtra("description", description);
                detailsActivity.putExtra("contact", contact);
                detailsActivity.putExtra("empcode", empcode);
                detailsActivity.putExtra("image", image);
                startActivity(detailsActivity);
            }

        }

    }
    private void loadProfiledata() {
        final ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
        Call<ResponseModel> call = apiService.getLatestNews("");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body().getSuccess()!=null) {
                    articleList = response.body().getSuccess();
                    if (articleList.size() > 0) {
                        profileListAdapter = new ProfileListAdapter(MainActivity.this, articleList, onItemclickListner);
                        activityMainBinding.profileListRecyclerView.setAdapter(profileListAdapter);

                    }
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}
