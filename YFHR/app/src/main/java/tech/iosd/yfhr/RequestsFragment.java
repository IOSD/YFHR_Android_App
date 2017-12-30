package tech.iosd.yfhr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestsFragment extends Fragment {

    private DatabaseReference mFriend_reqDatabase;
    private FirebaseAuth mFirebaseauth;
    private TextView chkchild;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public  String uid="";

    public RequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myview = (View) inflater.inflate(R.layout.fragment_requests, container, false);
        mFirebaseauth = FirebaseAuth.getInstance();


        if(mFirebaseauth.getCurrentUser()!=null){
            uid = mFirebaseauth.getCurrentUser().getUid();
        }
        mFriend_reqDatabase = FirebaseDatabase.getInstance().getReference().child("Friend_req").child(uid);

        chkchild = (TextView) myview.findViewById(R.id.childchk);

        recyclerView = (RecyclerView) myview.findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        mFriend_reqDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                List<String> lst = new ArrayList<String>(); // Result will be holded Here
                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                    if(String.valueOf(dsp.getValue()).equals("{request_type=received}"))
                    {
                        lst.add(String.valueOf(dsp.getKey()));
                    }

                }

                mAdapter = new Myadapter(getContext(),lst);
                recyclerView.setAdapter(mAdapter);

                if(lst.size()==0){
                    chkchild.setText("No Friend Requests");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        return myview;
    }

}