package com.example.android.dbex2;

/**
 * Created by Rajail Islam on 10/31/2017.
 */
public class Contact {
    int _id;
    String _name;
    String _phone_number;
    String email;
    public Contact(){   }
    public Contact(int id, String name, String _phone_number, String email){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this.email=email;
    }

    public Contact(int _id) {
        this._id = _id;
    }

    public Contact(String name, String _phone_number,String email){
        this._name = name;
        this._phone_number = _phone_number;
        this.email=email;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getPhoneNumber(){
        return this._phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}