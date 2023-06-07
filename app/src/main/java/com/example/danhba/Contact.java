package com.example.danhba;

public class Contact {
    private String Id;
    private String Nam;
    private String Phone;

    public Contact(String id, String nam, String phone) {
        Id = id;
        Nam = nam;
        Phone = phone;
    }

    public Contact() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNam() {
        return Nam;
    }

    public void setNam(String nam) {
        Nam = nam;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
