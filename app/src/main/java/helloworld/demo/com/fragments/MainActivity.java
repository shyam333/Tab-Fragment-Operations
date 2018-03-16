package helloworld.demo.com.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
//import helloworld.demo.com.fragments.fragments.Tab3Fragment;


public class MainActivity extends AppCompatActivity  {

    private SectionsPagerAdapter mSectionsPagerAdapter;
   // DataBaseHelper myDb;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

       // myDb = new DataBaseHelper(this);


    }



    //    @Override
//    public void onClick(View view)
//    {
//        switch (view.getId())
//        {
//            case R.id.btnViewAll:
//                viewAllContact();
//                break;
//
//        }
//    }
    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(),"CREATE USER");
        adapter.addFragment(new Tab2Fragment(),"VIEW USER");
       // adapter.addFragment(new Tab3Fragment(),"TAB3");
        viewPager.setAdapter(adapter);
    }
//    @Override
//    public void onBackPressed() {
//        Fragment fragment = fragmentManager.findFragmentById(R.id.frm1);
//        if(fragment != null)
//        {
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.remove(fragment);
//            fragmentTransaction.commit();
//        }
//        else {
//            super.onBackPressed();
//        }
//    }
//    public void viewAllContact() {
//        //TOAST OPERATIONS
//        if (editName.getText().toString().length() == 0) {
//            Toast.makeText(getContext(), "Enter roll no", Toast.LENGTH_SHORT).show();
//        } else {
//            //CALLING METHOD OF DATABASE HELPER CLASS
//
//            Contact contact = myDb.getContact(editName.getText().toString());
//            //TOAST OPERATIONS
//            if (contact.getName() != null) {
//                editName.setText(contact.getName());
//                editAddress.setText(contact.getAddress());
//                editDate.setText(contact.getDate());
//                imageView =contact.getImage();
//                byteToImage(imageView);
//                Toast.makeText(getContext(), "Data retrieved successfully", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private Bitmap byteToImage(byte[] imageView) {
//        bitmap = BitmapFactory.decodeByteArray(imageView, 0, imageView.length);
//         imageView2.setImageBitmap(bitmap);
//        return bitmap;
//    }


}
