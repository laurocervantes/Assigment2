package com.example.assigment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assigment2.adapter.EmailAdapter;
import com.example.assigment2.model.Email;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    TextView mSender;
    TextView mTitle;
    TextView mDetails;
    TextView mTime;
    ImageView mHeart;
    TextView mIcon;
    Email emailTwo;
    int mPosition;

  //  EmailAdapter emailAdapterTwo = new EmailAdapter(SecondActivity.this, emailList);
  //  RecyclerView recyclerViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSender = findViewById(R.id.SenderTv);
        mTitle = findViewById(R.id.tv_Title);
        mDetails = findViewById(R.id.DetailEmail);
        mTime = findViewById(R.id.TimeTv);
        mHeart = findViewById(R.id.icon_Favorite);
        mIcon = findViewById(R.id.IconTv);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mSender.setText(bundle.getString("Sender"));
            mTitle.setText(bundle.getString("Title"));
            mDetails.setText(bundle.getString("Details"));
            mTime.setText(bundle.getString("Time"));
            mIcon.setText(bundle.getString("Icon"));
            ((GradientDrawable)mIcon.getBackground()).setColor(bundle.getInt("ColorIcon"));
            emailTwo = bundle.getParcelable("Email_Object");
            mPosition = bundle.getInt("AdapterPosition");
        }

        mHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mHeart.getColorFilter() != null) {
                    mHeart.clearColorFilter();
                } else {
                    mHeart.setColorFilter(ContextCompat.getColor(SecondActivity.this,
                            R.color.colorPrimary));
                }
            }
        });

        mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTitle.setText("CHANGED AT CLICK");
                emailTwo.setTitle("CHANGED AT CLICK");
//                MainActivity.emailAdapter.notifyDataSetChanged();
            }
        });

        mSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSender.setText("CHANGED AT CLICK");
                emailTwo.setmSender("CHANGED AT CLICK");
//                MainActivity.emailAdapter.notifyDataSetChanged();
            }
        });

        mDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDetails.setText("CHANGED AT CLICK");
                emailTwo.setDetails("CHANGED AT CLICK");
//                MainActivity.emailAdapter.notifyDataSetChanged();
            }
        });

        mIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onPause();
//                onStop();
//                onDestroy();

                //you want to set the email to the intent to give back to your activity
                //set the result code here
                Intent sendBackIntent = new Intent();
                sendBackIntent.putExtra("Email_Object", emailTwo);
                sendBackIntent.putExtra("AdapterPosition", mPosition);
                setResult(Constants.ACTIVITY_TWO_RESULT_CODE, sendBackIntent);
                finish();
            }
        });

    }
}