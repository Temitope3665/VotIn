package com.example.votin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatNavigation extends Fragment {

    private ImageView searchOption, notificationImage, back, cancel;
    private TextView chat;
    private View chat_supporter;
    private ConstraintLayout profileView;
    private LinearLayout searchBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FrameLayout add_friend;
    LinearLayoutManager linearLayoutManager;

    public ChatNavigation() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.chat_navigation, container, false);

        searchOption = view.findViewById(R.id.searchIcon);
        notificationImage = view.findViewById(R.id.notification);
        chat = view.findViewById(R.id.textChats);
        profileView = view.findViewById(R.id.profileLayout);
        chat_supporter = view.findViewById(R.id.chatSupporter);
        searchBar = view.findViewById(R.id.searchLayout);
        back = view.findViewById(R.id.backIcon);
        cancel = view.findViewById(R.id.cancelIcon);
        recyclerView = view.findViewById(R.id.chatRecyclerView);
        add_friend = view.findViewById(R.id.addFriendContainer);



        // Adding Chat Swipe
       /* chatSwipeController chat_swipe_Controller = new chatSwipeController();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(chat_swipe_Controller);
        itemTouchHelper.attachToRecyclerView(recyclerView); */

       // Add a friend
        add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intAddFriend = new Intent(getActivity(), AddFriend.class);
                startActivity(intAddFriend);
            }
        });



       // Chat Swipe/ Slide
       ChatSwipeControllerOption swipeController = new ChatSwipeControllerOption(getActivity(), recyclerView, 150) {
           @Override
           public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<ChatSwipeControllerOption.MyButton> buffer) {
               buffer.add(new MyButton(getActivity(),
                       R.drawable.mutee,
                       Color.parseColor("#2E86C1"),
                       new MyButtonClickListener(){
                           @Override
                           public void onClick(int pos) {
                               Toast.makeText(getActivity(), "Delete Clicked", Toast.LENGTH_SHORT).show();
                           }
                       }));

               buffer.add(new MyButton(getActivity(),
                       R.drawable.deletee,
                       Color.parseColor("#2E86C1"),
                       new MyButtonClickListener(){
                           @Override
                           public void onClick(int pos) {
                               Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();
                           }
                       }));

               buffer.add(new MyButton(getActivity(),
                       R.drawable.pinn,
                       Color.parseColor("#2E86C1"),
                       new MyButtonClickListener(){
                           @Override
                           public void onClick(int pos) {
                               Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();
                           }
                       }));

           }
       };


        // Search Option
        searchOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationImage.setVisibility(View.GONE);
                chat.setVisibility(View.GONE);
                profileView.setVisibility(View.GONE);
                searchBar.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
            }
        });

        // Back Option

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationImage.setVisibility(View.VISIBLE);
                chat.setVisibility(View.VISIBLE);
                profileView.setVisibility(View.VISIBLE);
                searchBar.setVisibility(View.GONE);
            }
        });



        ArrayList<ChatModel> chatList = new ArrayList<>();
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Phoebe", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.profile_pic, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "You: Hello", "2:16PM", " "));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", ""));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.profile_pic, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "You: Hello", "2:16PM", ""));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.profile_pic, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "You: Hello", "2:16PM", "sent"));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.profile_pic, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "You: Hello", "2:16PM", "sent"));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));
        chatList.add(new ChatModel(R.drawable.user_one, R.drawable.online_status, R.drawable.chat_supporter_icon, "Linda", "How are you", "4:10PM", "4"));

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new ChatsViewAdapter(chatList);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        return view;
    }



}
