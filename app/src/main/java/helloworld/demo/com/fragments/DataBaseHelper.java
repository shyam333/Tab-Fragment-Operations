package helloworld.demo.com.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 09/02/18.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DB HELPER";
    public static final String DATABASE_NAME = "Employee";
    public static final String TABLE_NAME = "Employee_Details";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "ADDRESS";
    public static final String COL_4 = "DATE_AND_TIME";
    public static final String COL_5 = "IMAGE" ;
    private static final int DATABASE_VERSION = 1;



    public DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }





    private static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " ( " +
            COL_1 + " INTEGER PRIMARY KEY ," +
            COL_2 + " TEXT ," +
            COL_3 + " TEXT ," +
            COL_4 + " TEXT ," +
            COL_5 + " BLOB )";

    //CREATING SELECT_QUERY METHOD
    private String SELECT_QUERY = " SELECT " +
            COL_1 + " , " +
            COL_2 + " , " +
            COL_3 + " , " +
            COL_4 + " , " +
            COL_5 +
            " FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ? ";




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String checkName(String Name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try{
            cursor = db.rawQuery(SELECT_QUERY,new String[]{Name});
            if(cursor.getCount()>0)
            {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndex(COL_2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertData(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_2,contact.getName());
        Log.e(TAG,"GETTER NAME EXECUTED");
        contentvalues.put(COL_3,contact.getAddress());
        Log.e(TAG,"GETTER ADDRESS EXECUTED");
        contentvalues.put(COL_4,contact.getDate());
        Log.e(TAG,"GETTER DATE EXECUTED");
        contentvalues.put(COL_5,contact.getImage());
        Log.e(TAG,"GETTER IMAGE1 EXECUTED");
        long result = db.insert(TABLE_NAME,null,contentvalues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Contact getContact(String Name) {

        SQLiteDatabase db = this.getWritableDatabase();
        Contact contact = new Contact(Name);
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(SELECT_QUERY, new String[]{Name});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                contact.setId(cursor.getString(cursor.getColumnIndex(COL_1)));
                contact.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
                contact.setAddress(cursor.getString(cursor.getColumnIndex(COL_3)));
                contact.setDate(cursor.getString(cursor.getColumnIndex(COL_4)));
                contact.setImage(cursor.getBlob(cursor.getColumnIndex(COL_5)));

            }
            return contact;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

////        finally {
////            if (cursor!=null) {
////                cursor.close();
////
////                if (db != null)
////                    db.close();
////            }
////
////        }
//        return null;
//
//    }
//

    public ArrayList<Contact> getContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Contact> contactlist = new ArrayList<Contact>();
       // if (c1 != null && c1.getCount() != 0)
       // if (c1 != null && c1.moveToFirst())
        Cursor c1 = null;
        c1 = db.rawQuery(" SELECT * FROM Employee_Details ", null);
        c1.moveToFirst();
                do {
                    Contact contact = new Contact();

                    contact.setId(c1.getString(c1.getColumnIndex(COL_1)));


                    contact.setName(c1.getString(c1.getColumnIndex(COL_2)));


                    contact.setAddress(c1.getString(c1.getColumnIndex(COL_3)));


                    contact.setDate(c1.getString(c1.getColumnIndex(COL_4)));


                    contact.setImage(c1.getBlob(c1.getColumnIndex(COL_5)));

                    contactlist.add(contact);

                } while (c1.moveToNext());

            return contactlist;
    }



}
