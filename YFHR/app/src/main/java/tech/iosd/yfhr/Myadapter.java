package tech.iosd.yfhr;

/**
 * Created by spars on 30-12-2017.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private List<String> values;
    private DatabaseReference mdatabaseref;
    private Context mContext;
//    private String friendreq_sender_name="" , friendreq_sender_status="";

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Myadapter(Context context ,List<String> myDataset) {
        mContext = context;

        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final String friendreq_sender_id = values.get(position);
        mdatabaseref = FirebaseDatabase.getInstance().getReference().child("Users").child(friendreq_sender_id);
//        final String friendreq_sender_name , friendreq_sender_status;
        mdatabaseref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String  friendreq_sender_name= dataSnapshot.child("name").getValue().toString();
                holder.txtHeader.setText(friendreq_sender_name);
                String friendreq_sender_status=dataSnapshot.child("status").getValue().toString();
                holder.txtFooter.setText(friendreq_sender_status);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        holder.txtHeader.setText(friendreq_sender_name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                remove(position);

                Intent intent=new Intent(mContext.getApplicationContext(), ProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                intent.putExtra("user_id", friendreq_sender_id);
                mContext.getApplicationContext().startActivity(intent);

            }
        });

//        holder.txtFooter.setText(friendreq_sender_status);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}