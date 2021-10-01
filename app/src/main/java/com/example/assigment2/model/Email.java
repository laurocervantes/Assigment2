package com.example.assigment2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Email implements Parcelable {

    private String mSender;
    private String title;
    private String details;
    private String time;

    public Email(String mSender, String title, String details, String time) {
        this.mSender = mSender;
        this.title = title;
        this.details = details;
        this.time = time;
    }

    protected Email(Parcel in) {
        mSender = in.readString();
        title = in.readString();
        details = in.readString();
        time = in.readString();
    }

    public static final Creator<Email> CREATOR = new Creator<Email>() {
        @Override
        public Email createFromParcel(Parcel in) {
            return new Email(in);
        }

        @Override
        public Email[] newArray(int size) {
            return new Email[size];
        }
    };

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void upDateEverything (String sender, String title, String details,
                                 String time) {
        setmSender(sender);
        setTitle(title);
        setDetails(details);
        setTime(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSender);
        parcel.writeString(title);
        parcel.writeString(details);
        parcel.writeString(time);
    }
}
