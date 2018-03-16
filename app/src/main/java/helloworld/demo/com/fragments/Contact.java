package helloworld.demo.com.fragments;

import java.util.ArrayList;

/**
 * Created by shyamramesh on 09/02/18.
 */

public class Contact extends ArrayList<String> {
    public String Id;
    public String Name;
    public String Address;
    public String Date;
    public byte[] Image;
   // public Bitmap Image2;


    public byte[] getImage() {
        return Image;
    }

//    public void setImage1(byte[] image1) {
//        Image1 = image1;
//    }
//
//    public Bitmap getImage2() {
//        return Image2;
//    }
//
//    public void setImage2(Bitmap image2) {
//        Image2 = image2;
//    }

    public Contact(String Id, String Name, String Address, String Date, byte[] Image)
    {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Date = Date;
        this.Image = Image;
    }
//    public Contact(String Id, String Name, String Address, String Date,Bitmap Image2)
//    {
//        this.Id = Id;
//        this.Name = Name;
//        this.Address = Address;
//        this.Date = Date;
//        this.Image2 = Image2;
//    }
    public Contact(String Name)
    {

        this.Name = Name;

    }

    public Contact() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

//    public Bitmap getImage() {
//        DbBitmapUtility dbBitmapUtility = new DbBitmapUtility();
//        dbBitmapUtility.getImage(Image1);
//
//        return Image2;
//    }

    public void setImage(byte[] image) {
        Image = image;
    }


}
