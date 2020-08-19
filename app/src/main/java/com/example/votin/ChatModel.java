package com.example.votin;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ChatModel {

    private int mProfile_picture, mOnline_status, mChat_supporter;
    private FrameLayout mNo_of_messages;
    private String mName, mChat_text, mMessage_time, mNumber_of_message;
    private LinearLayout enterMessage;


   public ChatModel(int profile_picture, int online_status, int chat_supporter, String name, String chat_text, String message_time, String number_of_message){

       mProfile_picture = profile_picture;
       mOnline_status = online_status;
       mChat_supporter = chat_supporter;
       mName = name;
       mChat_text = chat_text;
       mNumber_of_message = number_of_message;
       mMessage_time = message_time;
    }

    public int getProfilePicture () {
       return mProfile_picture;
    }

    public int getChatSupporter () {return mChat_supporter;}

    public int getOnlineStatus () {
       return mOnline_status;
    }

    public String getName () {
       return mName;
    }

    public String getChatText () {
        return mChat_text;
    }

    public String getMessageTime() {
        return mMessage_time;
    }

    public String getNumberOfMessages () {
        return mNumber_of_message;
    }

}
