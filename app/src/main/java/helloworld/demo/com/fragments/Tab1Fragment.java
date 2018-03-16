package helloworld.demo.com.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

//import helloworld.demo.com.fragments.MainActivity.Main2Activity;
//import helloworld.demo.com.fragments.RecyclerView.Images1Adapter;

import static android.app.Activity.RESULT_OK;

/**
 * Created by shyamramesh on 09/02/18.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "TAB1 ACTIVITY";
    private int PICK_IMAGE_REQUEST = 1;
    private Bitmap bitmap;
    EditText editName, editAddress, editDate;
    ImageView imageView;
    Button buttonSave;
    Button buttonPickImage;
   // private Images1Adapter mAdapter;
   // private Context mContext;
  //  Button buttonViewContacts;
    //private byte[] mImage;
    //  Context context;

    DataBaseHelper myDb;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);

        myDb = new DataBaseHelper(getContext());
        buttonSave = (Button) v.findViewById(R.id.btnsave);
        buttonPickImage = (Button) v.findViewById(R.id.btnselectimg);
        editName = (EditText) v.findViewById(R.id.edt1);
        editAddress = (EditText) v.findViewById(R.id.edt2);
        editDate = (EditText) v.findViewById(R.id.edt3);
        imageView = (ImageView) v.findViewById(R.id.img);
     //   mAdapter = new Images1Adapter(mContext);
     //   myDb = new DataBaseHelper(getActivity());


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//                startActivity(intent);
                addData();
              //  addImageItem();
               // addDataItems();
                //saveImage();
            }
        });


        buttonPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });


//        buttonViewContacts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),Main2Activity.class);
//                startActivity(intent);
//
//                viewContacts();
//
//                //saveImage();
//            }
//        });
        return v;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);

                imageView.setImageBitmap(bitmap);

              //  mAdapter.addItem1(bitmap);



                //SAVE IMAGE TO DATABASE
                //   DbBitmapUtility dbBitmapUtility = new DbBitmapUtility();
                //   dbBitmapUtility.getBytes(bitmap);

                //myDb.addData(bitmap);

                Log.d(TAG, "IMAGE ITEM SELECTED");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }




//    public void buttonClicked(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.btnselectimg:
//                    selectImage();
//                break;
//        }
//    }

    public void addData() {

        if (editName.getText().toString().length() == 0) {
            Toast.makeText(getContext(), "Enter Name", Toast.LENGTH_SHORT).show();

        } else if (editAddress.getText().toString().length() == 0) {
            Toast.makeText(getContext(), "Enter Address", Toast.LENGTH_SHORT).show();
        } else if (editDate.getText().toString().length() == 0) {
            Toast.makeText(getContext(), "Enter DateandTime", Toast.LENGTH_SHORT).show();
        } else {
            String name = myDb.checkName(editName.getText().toString());
            if (name == null) {
                boolean isInserted = myDb.insertData(new Contact(null,
                        editName.getText().toString(),
                        editAddress.getText().toString(),
                        editDate.getText().toString(),
                        imageViewToByte(imageView)));
                if (isInserted)
                    Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getContext(), "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        }
    }

    private byte[] imageViewToByte(ImageView imageView) {
        imageView.setImageBitmap(bitmap);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
//        DbBitmapUtility dbBitmapUtility = new DbBitmapUtility();
//        dbBitmapUtility.getBytes(bitmap);
        // return stream.toByteArray();
    }
    //select image
//    public void selectImage(){
//        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//        photoPickerIntent.setType("image/*");
//        startActivityForResult(photoPickerIntent,2);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode,int resultCode,Intent data)
//    {
//        switch(requestCode)
//        {
//            case 2:
//                if(resultCode == RESUlT_OK)
//                {
//                    Uri choosenImage = data.getData();
//
//                    if(choosenImage != null)
//                    {
//                        bp = decodeUri(choosenImage,400);
//                        pic.setImageBitmap(bp);
//                    }
//                }
//        }
//    }


//    public static void saveImage()
//    {
//
//    }


//    public void viewContacts() {
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
//                mImage = contact.getImage();
//                byteToImage(mImage);
//                Toast.makeText(getContext(), "Data retrieved successfully", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

//    private Bitmap byteToImage(byte[] mImage) {
//        bitmap = BitmapFactory.decodeByteArray(mImage, 0, mImage.length);
//        imageView.setImageBitmap(bitmap);
//        return bitmap;
//    }

//    private void addDataItems()
//    {
//        Tab2Fragment tab2Fragment = new Tab2Fragment();
//        String txt1 = editName.getText().toString();
//        String txt2 = editAddress.getText().toString();
//        String txt3 = editDate.getText().toString();
//
//        if(txt1.length() != 0)
//        {
//            mAdapter.addItem2(txt1,txt2,txt3);
//        }
//    }


}
