package helloworld.demo.com.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

//import helloworld.demo.com.fragments.fragments.BlankFragment;
//import helloworld.demo.com.fragments.fragments.BlankFragment;
//import helloworld.demo.com.fragments.fragments.BlankFragment;


/**
 * Created by shyamramesh on 13/02/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>
{
    ArrayList<Contact> contactlist;
    Context context;
    private byte[] mImage;
  // public ImageView mImageView;
    private Bitmap bitmap;
    Button button;
  //  Tab2Fragment tab2Fragment = ViewItemsFragment.newInstance();
 //   ViewItemsFragment obj = new ViewItemsFragment();
   // private GettingMessage gettingMessage;




    public CustomAdapter(Context context,ArrayList<Contact>contactlist)
    {
        this.context = context;
        this.contactlist = contactlist;
    }

//
//    public interface GettingMessage
//    {
//        void viewContact(String message);
//        // public void viewContact(String message);
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.view_items, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        final Contact m;
        m = contactlist.get(position);
        holder.mName.setText("" +m.getName());
        holder.mAddress.setText("" +m.getAddress());
        holder.mDate.setText("" +m.getDate());
        mImage = m.getImage();
        byteToImage(mImage);
        holder.mImageView.setImageBitmap(bitmap);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //obj.viewContact(message);
                //obj.displayDetails1(message);
//                Intent intent = new Intent(context,ViewItemsFragment.class);
//                intent.putExtra("NAME",m.getName());
//                context.startActivity(intent);
//                String message = m.getName();
 //               gettingMessage.viewContact(message);
                ViewItemsFragment viewItemsFragment = new ViewItemsFragment();
                Bundle arguments = new Bundle();
                arguments.putString("key1",m.getName());
                arguments.putString("key2",m.getAddress());
                arguments.putString("key3",m.getDate());
                arguments.putByteArray("key4",m.getImage());
                viewItemsFragment.setArguments(arguments);

               // arguments.putString("key2",m.getAddress());
               // arguments.putString("key3",m.getDate());



                FragmentManager fm =((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frm1,viewItemsFragment).addToBackStack(null);
                ft.commit();


            }
        });

       // animate(holder);
        // holder.mImage.setImageBitmap();
        //m.setImage(im);
    }

    private Bitmap byteToImage(byte[] mImage) {
        bitmap = BitmapFactory.decodeByteArray(mImage, 0, mImage.length);
        return bitmap;
    }
    @Override
    public int getItemCount()
    {
        return contactlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public EditText mName;
        public EditText mAddress;
        public EditText mDate;
        public ImageView mImageView;
        public RelativeLayout mRelativeLayout;
        public Button button;

        public ViewHolder(View v)
        {
            super(v);
            mName = (EditText) v.findViewById(R.id.edt1);
            mAddress = (EditText) v.findViewById(R.id.edt2);
            mDate = (EditText) v.findViewById(R.id.edt3);
            mImageView = (ImageView)v.findViewById(R.id.img);
            mRelativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
            button = (Button)v.findViewById(R.id.btnretrive);
        }



    }

//    public void animate(RecyclerView.ViewHolder viewHolder) {
//        @SuppressLint("ResourceType") final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.animator.anim2);
//        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        Activity activity = (Activity)context;
//        try {
//            gettingMessage = (GettingMessage) activity;
//        }
//        catch (Exception e)
//        {
//          throw new ClassCastException(activity.toString()+" must override onviewAll...");
//        }
//    }


//
}


