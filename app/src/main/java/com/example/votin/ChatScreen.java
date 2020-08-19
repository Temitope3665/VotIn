package com.example.votin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ChatScreen extends AppCompatActivity {

    private ImageView back_option, video_chat, voice_call, chat_user_profile,  online_status;
    private TextView user_name, last_seen;
    private FrameLayout typing, send_action;
    private ImageView attachment, voice_recording;
    private EditText type_msg;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        back_option = findViewById(R.id.backButton);


        // Go back to Chat List
        back_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intChatsNavigation = new Intent (ChatScreen.this, Home.class);
                startActivity(intChatsNavigation);
                finish();
            }
        });
    }
}