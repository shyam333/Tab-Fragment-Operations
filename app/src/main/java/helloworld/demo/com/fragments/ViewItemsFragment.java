package helloworld.demo.com.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewItemsFragment extends Fragment  {


    private static final String TAG = "VIEWITEMSFRAGMENT";
    TextView textView1,textView2,textView3;
  //  byte[] imageViewByte;
    ImageView imageView;
    Button button;
    Bitmap bitmap;

    DataBaseHelper myDb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.view_items_fragment, container, false);
        button = (Button)v.findViewById(R.id.btn);
        textView1 = (TextView)v.findViewById(R.id.txt1);
        textView2 = (TextView)v.findViewById(R.id.txt2);
        textView3 = (TextView)v.findViewById(R.id.txt3);
        imageView =(ImageView)v.findViewById(R.id.img);
        myDb = new DataBaseHelper(getContext());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    Intent intent = new Intent(getContext(),MainActivity.class);
//                Intent intent = new Intent(getActivity(),Tab2Fragment.class);
//                getActivity().startActivity(intent);
                getFragmentManager().popBackStackImmediate();

            }
        });

        Bundle arguments = getArguments();
        String item1 = arguments.getString("key1");
        String item2 = arguments.getString("key2");
        String item3 = arguments.getString("key3");
        byte[] item4 = arguments.getByteArray("key4");
        byteToImage(item4);

      //  String item2 = arguments.getString("key2");
       // String item3 = arguments.getString("key3");

        textView1.setText(item1);
        textView2.setText(item2);
        textView3.setText(item3);
        imageView.setImageBitmap(bitmap);
        //textView1.setText(String.format("Name: %s", item1));
      //  textView2.setText(String.format("Age: %s", item2));
      //  textView3.setText(String.format("Age: %s", item3));

        //textView1.setText(message);
        //  displayDetails(message);
        // viewContact(message);

       // Contact contact = new Contact();
//        textView1.setText(message);
//        textView2.setText(message);
//        textView3.setText(message);
//        imageView.setImageBitmap(bitmap);
        return v;
    }

    private Bitmap byteToImage(byte[] item4) {

        bitmap = BitmapFactory.decodeByteArray(item4, 0, item4.length);
        imageView.setImageBitmap(bitmap);
        return bitmap;
    }

//    public static Tab2Fragment newInstance() {
//        ViewItemsFragment viewItemsFragment = new ViewItemsFragment();
//            Contact contact = new Contact();
//        Bundle args = new Bundle();
//        args.putString("key",contact.getName());
//        viewItemsFragment.setArguments(args);
//            return ;
//    }


//    public void displayDetails(message) {
//        textView1.setText(getName());
//        textView2.setText(getAddress());
//        textView3.setText(getDate());
//      //  imageViewByte = m.getImage();
//      //  byteToImage(imageViewByte);
//        imageView.setImageBitmap(bitmap);
//    }
//
//    private Bitmap byteToImage(byte[] imageViewByte) {
//
//        bitmap = BitmapFactory.decodeByteArray(imageViewByte, 0, imageViewByte.length);
//        imageView.setImageBitmap(bitmap);
//        return bitmap;
//    }

//    public void displayDetails1(String name) {
//
//        textView1.setText(String.format("Name: %s", name));
//    }

      //@Override
//    public void viewContact(String message) {
//        Contact contact = myDb.getContact(message);
//        //TOAST OPERATIONS
//        if (contact.getName() != null) {
//            textView1.setText(contact.getName());
//            textView2.setText(contact.getAddress());
//            textView3.setText(contact.getDate());
//            imageViewByte = contact.getImage();
//            byteToImage(imageViewByte);
//            Toast.makeText(getContext(), "Data retrieved successfully", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    private Bitmap byteToImage(byte[] imageViewByte) {
//
//        bitmap = BitmapFactory.decodeByteArray(imageViewByte, 0, imageViewByte.length);
//        imageView.setImageBitmap(bitmap);
//        return bitmap;
//    }
}
