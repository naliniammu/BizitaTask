package com.example.bizitatask;

import com.example.bizitatask.entities.Profile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class ResponseModel {
    @SerializedName("Success")
    @Expose
    private List<Profile> success = null;

    public List<Profile> getSuccess() {
        return success;
    }

    public void setSuccess(List<Profile> success) {
        this.success = success;
    }
}
