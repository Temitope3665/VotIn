package com.example.votin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatsViewAdapter extends RecyclerView.Adapter<ChatsViewAdapter.ViewHolder>{

    private ArrayList<ChatModel> mChatModel;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate chat_row layout
        View chatRows = inflater.inflate(R.layout.chat_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(chatRows);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ChatModel  currentChat = mChatModel.get(position);

        holder.profile_picture.setImageResource(currentChat.getProfilePicture());
        holder.online_status.setImageResource(currentChat.getOnlineStatus());
        holder.name.setText(currentChat.getName());
        holder.chat_text.setText(currentChat.getChatText());
        holder.message_time.setText(currentChat.getMessageTime());
        holder.number_of_message.setText(currentChat.getNumberOfMessages());
        holder.chat_supporter.setImageResource(currentChat.getChatSupporter());

    }

    @Override
    public int getItemCount() {
        return mChatModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView profile_picture, online_status, chat_supporter;
        private TextView name, chat_text, message_time, number_of_message;
        private LinearLayout layout;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            profile_picture = itemView.findViewById(R.id.user_one_picture);
            online_status = itemView.findViewById(R.id.online);
            name = itemView.findViewById(R.id.userName);
            chat_text = itemView.findViewById(R.id.textChat);
            message_time = itemView.findViewById(R.id.time);
            number_of_message = itemView.findViewById(R.id.numberOfMessages);
            chat_supporter = itemView.findViewById(R.id.chatSupporter);
            layout = itemView.findViewById(R.id.mainLayout);

            // Enter the chat screen
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intChatScreen = new Intent(itemView.getContext(), ChatScreen.class);
                    itemView.getContext().startActivity(intChatScreen);
                }
            });
        }
    }

    public ChatsViewAdapter(ArrayList<ChatModel> chatModel) {
        mChatModel = chatModel;
    }
}
