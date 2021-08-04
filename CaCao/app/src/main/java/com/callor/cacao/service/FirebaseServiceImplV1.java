package com.callor.cacao.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.callor.cacao.adapter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

// child realtime 에서 변화가 생기면 가져와서 쓸수있게 해줌
public class FirebaseServiceImplV1 implements ChildEventListener {

    private ChattAdapter apdapter;

    public FirebaseServiceImplV1(ChattAdapter apdapter) {
        this.apdapter = apdapter;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        Chatt chattVO = snapshot.getValue(Chatt.class);
        apdapter.addChatList(chattVO);
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
