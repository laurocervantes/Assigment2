package com.example.assigment2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assigment2.adapter.EmailAdapter;
import com.example.assigment2.model.Email;

import java.util.ArrayList;
import java.util.List;

// Main activity
public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<Email> mEmailList = new ArrayList<>();
    static EmailAdapter emailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mRecyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));


        Email mEmail = new Email("Lauro Cervantes", "Feedback Group",
                "Please come back in time to set up FeedBack Meeting", "2:00pm");
        mEmailList.add(mEmail);

        Email mEmailTwo = new Email("MOM", "Call Me", "Blah bLAH blah" +
                "............", "1:00am");
        mEmailList.add(mEmailTwo);

        Email mEmailThree = new Email("Enhance IT", "Submit Timesheet",
                "This is an email for you to submit your timesheet", "10:00am");
        mEmailList.add(mEmailThree);

        Email mEmailFour = new Email("AT&T", "Payment Receipt",
                "We have received your payment for your phone", "08:23am");
        mEmailList.add(mEmailFour);

        Email mEmailFive = new Email("Boston University", "Student ID",
                "Please update your student iD password", "11:00pm");
        mEmailList.add(mEmailFive);

        Email mEmailSix = new Email("Sister", "Hi Loser",
                "Helloooooooooooooooooooooo", "12:00pm");
        mEmailList.add(mEmailSix);

        Email mEmailSixE = new Email("Sister", "Hi Loser",
                "Helloooooooooooooooooooooo", "12:00pm");
        mEmailList.add(mEmailSixE);

        Email mEmailSixa = new Email("Sister", "Hi Loser",
                "Helloooooooooooooooooooooo", "12:00pm");
        mEmailList.add(mEmailSixa);

        Email mEmailSixw = new Email("Sister", "Hi Loser",
                "Helloooooooooooooooooooooo", "12:00pm");
        mEmailList.add(mEmailSixw);


        emailAdapter = new EmailAdapter(MainActivity.this,
                mEmailList);
        mRecyclerView.setAdapter(emailAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            //we respond to our second activity here.
            //here you probably want to update your recyclerview
            if (resultCode == Constants.ACTIVITY_TWO_RESULT_CODE) {
                if (data != null) {
                    Email retrievedEmail = data.getParcelableExtra("Email_Object");
                    int position = data.getIntExtra("AdapterPosition", 0);
                    mEmailList.set(position, retrievedEmail);
                    emailAdapter.setList(mEmailList);
                }
            }
        }
    }
}