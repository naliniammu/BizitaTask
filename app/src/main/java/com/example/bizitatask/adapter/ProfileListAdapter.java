package com.example.bizitatask.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bizitatask.R;
import com.example.bizitatask.entities.Profile;

import java.util.List;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ViewHolder> {
    private List<Profile> profileList;
    private Context context;
    private OnItemclickListner onItemclickListner;
    public ProfileListAdapter(FragmentActivity context, List<Profile> profiles, OnItemclickListner onItemclickListner) {
        this.context = context;
        this.profileList = profiles;
        this.onItemclickListner = onItemclickListner;
    }
    public interface OnItemclickListner {
        void onItemClick(int status, int position);
    }
    @NonNull
    @Override
    public ProfileListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_custom_list, viewGroup, false);
        return new ProfileListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProfileListAdapter.ViewHolder viewHolder, final int position) {
        final Profile articleModel = profileList.get(position);
        if(!TextUtils.isEmpty(articleModel.getName())) {
            viewHolder.profile_name.setText(articleModel.getName());
        }
        if(!TextUtils.isEmpty(articleModel.getContact())) {
            viewHolder.contact_textview.setText(articleModel.getContact());
        }
        if (articleModel.getImage() != null) {
            Glide.with(context)
                    .load(articleModel.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(viewHolder.profile_image);
        } else {
            viewHolder.profile_image.setImageDrawable(null);
        }

        viewHolder.root_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemclickListner != null) {
                    onItemclickListner.onItemClick(1, position);

                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return profileList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView profile_name;
        private TextView contact_textview;
        private RelativeLayout root_layout;
        private ImageView profile_image;

        ViewHolder(View view) {
            super(view);
            profile_name = view.findViewById(R.id.profile_name);
            contact_textview = view.findViewById(R.id.contact_textview);
            root_layout = view.findViewById(R.id.root_layout);
            profile_image = view.findViewById(R.id.profile_image);
        }
    }
}
