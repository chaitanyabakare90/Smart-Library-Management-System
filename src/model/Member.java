package model;

public class Member {
    private int member_id;
    private String name;
    private String email;
    private String phoneNumber;

    public Member(int member_id,String name,String email,String phoneNumber){
        this.member_id = member_id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId(){
        return member_id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override 

    public String toString(){
        return "Member_Id :" + member_id +
                "\nMember_Name :" + name +
                "\nMember_Email :" + name +
                "\nMember_PhoneNumber :" + phoneNumber; 
    }
}
