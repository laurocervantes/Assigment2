package com.example.assigment2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2.R;
import com.example.assigment2.SecondActivity;
import com.example.assigment2.model.Email;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private List<Email> mEmailData;
    private Context mContext;

    public EmailAdapter (Context context, List data){
        this.mContext = context;
        this.mEmailData = data;
    }

    public void setList(List<Email> emailData){
        mEmailData = emailData;
        notifyDataSetChanged();
    }


    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_items,
                parent,false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        Email currentEmail = mEmailData.get(position);
        int currentPosition = position;

        holder.mSender.setText(mEmailData.get(position).getmSender());
        holder.mTitle.setText(mEmailData.get(position).getTitle());
        holder.mDetails.setText(mEmailData.get(position).getDetails());
        holder.mTime.setText(mEmailData.get(position).getTime());

        holder.mIcon.setText(mEmailData.get(position).getmSender().substring(0,1));

        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        ((GradientDrawable) holder.mIcon.getBackground()).setColor(color);

        holder.mHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mHeart.getColorFilter() != null) {
                    holder.mHeart.clearColorFilter();
                } else {
                    holder.mHeart.setColorFilter(ContextCompat.getColor(mContext,
                            R.color.colorPrimary));
                }
            }
        });

        holder.rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SecondActivity.class);
                intent.putExtra("Sender", holder.mSender.getText().toString());
                intent.putExtra("Title", holder.mTitle.getText().toString());
                intent.putExtra("Details", holder.mDetails.getText().toString());
                intent.putExtra("Time", holder.mTime.getText().toString());
                intent.putExtra("Icon", holder.mIcon.getText().toString());
                intent.putExtra("ColorIcon", color);
                intent.putExtra("AdapterPosition", currentPosition);

                //add the email object to your intent
                intent.putExtra("Email_Object", currentEmail);

                //make note of this request code because it will be used later
                ((AppCompatActivity) mContext).startActivityForResult(intent, 1000);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mEmailData.size();
    }

    public class EmailViewHolder extends RecyclerView.ViewHolder {

        private TextView mIcon;
        private TextView mSender;
        private TextView mTitle;
        private TextView mDetails;
        private TextView mTime;
        private ImageView mHeart;
        RelativeLayout rLayout;

        public EmailViewHolder(View itemView) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.icon_tv);
            mSender = itemView.findViewById(R.id.sender_tv);
            mTitle = itemView.findViewById(R.id.emailtitle_tv);
            mDetails = itemView.findViewById(R.id.email_detailtv);
            mTime = itemView.findViewById(R.id.time_tv);
            mHeart = itemView.findViewById(R.id.fav_icon);
            rLayout = itemView.findViewById(R.id.layout);
        }
    }
}
