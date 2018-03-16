package helloworld.demo.com.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

//import helloworld.demo.com.fragments.MainActivity.Main2Activity;
//import helloworld.demo.com.fragments.CustomAdapter;

import java.util.ArrayList;

//import helloworld.demo.com.fragments.MainActivity.Main2Activity;
//import helloworld.demo.com.fragments.RecyclerView.Images1Adapter;
//import helloworld.demo.com.fragments.MainActivity.Main2Activity;


/**
 * Created by shyamramesh on 09/02/18.
 */


public class Tab2Fragment extends Fragment {

    private static final String TAG = "TAB2 ACTIVITY";
    ArrayList<Contact> contactlist;
    private Context context;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private CustomAdapter mAdapter;
   // RelativeLayout relativeLayout;
    FrameLayout frameLayout;
    DataBaseHelper myDb;




        @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.frame_layout, container, false);


            context = getContext();
            myDb = new DataBaseHelper(getContext());
            contactlist = myDb.getContacts();

            frameLayout = (FrameLayout)v.findViewById(R.id.frm1);
          //  relativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
            recyclerView = (RecyclerView) v.findViewById(R.id.rc);

            mAdapter = new CustomAdapter(context, contactlist);
            linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(mAdapter);

//
//        DefaultItemAnimator animator = new DefaultItemAnimator();
//        animator.setMoveDuration(1000);
//        recyclerView.setItemAnimator(animator);

            return v;

        }

//    public static ViewItemsFragment newInstance() {
//            Tab2Fragment tab2Fragment = new Tab2Fragment();
//            Contact contact = new Contact();
//        Bundle args = new Bundle();
//        args.putString("key",contact.getName());
//        tab2Fragment.setArguments(args);
//            return tab2Fragment;
//    }
}

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity = (Activity)context;
//        try {
//            gettingMethodContact = (GettingMethodContact) activity;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            //throw new ClassCastException(activity.toString()+" must override onviewAll...");
//        }
//    }
//
//    public interface GettingMethodContact
//    {
//        public void viewAllContact();
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity = (Activity)context;
//        try {
//            gettingMethodViewAll = (GettingMethodViewAll) activity;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            //throw new ClassCastException(activity.toString()+" must override onviewAll...");
//        }
//    }
//
//    public interface GettingMethodViewAll
//    {
//        public void viewAllContact();
//    }


//    @Override
//    public void onAttach(Activity activity)
//    {
//        super.onAttach(activity);
//    }

//    public interface GettingContacts
//    {
//        public void viewAllContact();
//    }
//
//}


// public class Tab2Fragment extends Fragment {
//    private static final String TAG = "TAB2 ACTIVITY";
//   // private byte[] bitmap;
//    private Bitmap bitmap;
//    EditText editName,editAddress,editDate;
//    ImageView imageView2;
//    DataBaseHelper myDb;
//    byte[] imageView;
//    Button buttonRetrive;
//    Button buttonviewAll;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.tab2, container, false);
//
//
//        editName = (EditText) v.findViewById(R.id.edt1);
//        editAddress = (EditText)v.findViewById(R.id.edt2);
//        editDate = (EditText)v.findViewById(R.id.edt3);
//        imageView2 = (ImageView)v.findViewById(R.id.img);
//        buttonRetrive = (Button)v.findViewById(R.id.btnretrive);
//        buttonviewAll = (Button)v.findViewById(R.id.btnViewAll);
//        myDb = new DataBaseHelper(getActivity());
//
//
//
////        buttonRetrive.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//
////               EmployeeDetailsFragment employeeDetailsFragment = new EmployeeDetailsFragment();
////                FragmentManager manager = getFragmentManager();
////                manager.beginTransaction().
////                        replace(R.id.main_content,employeeDetailsFragment,employeeDetailsFragment.getTag()).
////                        commit();
//
//              //  DbBitmapUtility dbBitmapUtility = new DbBitmapUtility();
//               // dbBitmapUtility.getImage(image);
//
////        buttonRetrive.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////
////
////            }
////        });
//
//        buttonviewAll.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                viewAllContact();
//                android.content.Intent intent = new android.content.Intent(getActivity(), Main2Activity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//         return v;
//
//
//
//    }
//
//    public void viewContact()
//    {
//        if(editName.getText().toString().length() == 0)
//        {
//            Toast.makeText(getContext(),"Enter name",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Contact contact = myDb.getContact(editName.getText().toString());
//             if(contact.getName() != null)
//            {
//                editName.setText(contact.getName());
//                Log.e(TAG,"GETTER NAME EXECUTED");
//                editAddress.setText(contact.getAddress());
//                Log.e(TAG,"GETTER ADDRESS EXECUTED");
//                editDate.setText(contact.getDate());
//                Log.e(TAG,"GETTER DATE EXECUTED");
//               // contact.getImage();
//               // contact.setImage(contact.getImage());
//                    imageView =contact.getImage();
//                    byteToImage(imageView);
//              //  Bitmap bitmap = byteToImage(imageView(contact.setImage(contact.getImage())));
//                Log.e(TAG,"GETTER IMAGE EXECUTED");
//               // byteToImage(imageView);
//                Toast.makeText(getContext(), "Data retrieved successfully", Toast.LENGTH_SHORT).show();
//            }}}
//
//    private Bitmap byteToImage(byte[] imageView) {
//      //  imageView.setImageBitmap(bitmap);
//       /// Contact contact = new Contact();
//        //contact.setImage(contact.getImage());
//
//        bitmap = BitmapFactory.decodeByteArray(imageView, 0, imageView.length);
//        imageView2.setImageBitmap(bitmap);
//       // imageView.setImageBitmap(bitmap);
//      //  return BitmapFactory.decodeByteArray(imageView,0,imageView.length);
//        return bitmap;
//    }
//
//




