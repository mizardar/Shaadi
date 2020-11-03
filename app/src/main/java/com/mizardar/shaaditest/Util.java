package com.mizardar.shaaditest;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {

    public static String getDOB(String dobStr) {
        //1946-07-10T16:14:20.721Z
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date dateOfBirth = format.parse(dobStr);
            SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd MMM, yyyy", Locale.US);
            birthdayFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            if (dateOfBirth != null) {
                return birthdayFormat.format(dateOfBirth);
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @BindingAdapter("userImage")
    public static void setUserImage(AppCompatImageView userImage, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(userImage.getContext()).load(imageUrl).placeholder(R.drawable.image_placeholder).into(userImage);
        }
    }
}
