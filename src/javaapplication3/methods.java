/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.sql.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arqam
 */
public interface methods{
    void Register();
    void Login();
    void Menu();
    void CheckDetails();
    void UploadAssignment();
    void ViewAssignment();
    void MarkAttendance();
    void ViewAttendance();
    void EditDetails();
    void EditStudentDetails();
    void EditTeacherDetails();
    void addMarks();
    void viewMarks();
}
class StudentManagementSystem implements methods{

      public void theQuery(String query){
      Connection con = null;
      Statement st = null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
          st = con.createStatement();
          st.executeUpdate(query);
      }catch(Exception ex){
      }
  }
    public void Register() {
        
    }

    public void Login() {
    }
    
    public void Menu(){};
    
    public void CheckDetails() {
    }

    public void UploadAssignment() {
    }

    public void ViewAssignment() {
    }

    public void MarkAttendance() {
    }

    public void ViewAttendance() {
    }
    
    public void EditDetails(){}
    
    public void EditStudentDetails(){}
    
    public void EditTeacherDetails(){}
    
    public void addMarks(){};
    
    public void viewMarks(){};
    
}

class Students extends StudentManagementSystem{

    Scanner obj = new Scanner(System.in);
    
    
    public void Register(){
        String username;
        String password;
        String name;
        String rollno;
        String section;
        int i = 0;
        System.out.println("Enter Username: ");
        username = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Password: ");
        password = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Name: ");
        name = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter RollNo: ");
        rollno = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Section: ");
        section = obj.nextLine();
        System.out.println("\n");

        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "Insert into student (Name,Username,Password,RollNo,Section) values (?,?,?,?,?)";
                String st = "Insert into attendance set Name = ? , RollNo = ? , Section = ?";              
                PreparedStatement p = con.prepareStatement(st);
                p.setString(1, name);
                p.setString(2, rollno);
                p.setString(3, section);
                p.executeUpdate();
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, rollno);
                ps.setString(5, section);
                
                ps.executeUpdate();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
    public void Login(){

        String username, password, str;
        String uname = "", pword = "";
        System.out.println("Username: ");
        username = obj.nextLine();
        System.out.println("");
        System.out.println("Password: ");
        password = obj.nextLine();
        System.out.println("");   
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select Username, Password from student");
                
                while(rs.next()){
                    uname = rs.getString(1);
                    pword = rs.getString(2);
                    if(username.equals(uname) && password.equals(pword)){
                        System.out.println("Login Successful!");
                        Menu(uname);
                        break;
                    }

                    
                }
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Menu(String uname){
        System.out.println("1. Check Details");
        System.out.println("2. Edit Details");
        System.out.println("3. Check Attendance");
        System.out.println("4. Check Assignment");
        System.out.println("5. Check MarkSheet");
        System.out.println("Enter your choice: ");
        int choice = obj.nextInt();
        obj.nextLine();
        
        switch(choice){
            case 1:
                CheckDetails(uname);
                break;
            case 2:
                EditDetails(uname);
                break;
            case 3:
                ViewAssignment();
                break;
            case 4: 
                ViewAttendance();
                break;
            case 5: 
                viewMarks();
                break;
                
            default:
                System.out.println("Error");
                
    }
            
        
    }
    
    public void CheckDetails(String uname){
        try {
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("select *from student where username = ?");
                pst.setString(1, uname);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                String name = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String rollno = rs.getString(4);
                String section = rs.getString(5);
                    System.out.println(name+ " " + username + " " + password + " " + rollno + " " + section);
                }
                
                
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
    public void EditDetails(String uname){
        
        
        
        int i = 0;
        String username;
        String password;
        String name;
        String rollno;
        String section;
        System.out.println("Enter New Username: ");
        username = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Password: ");
        password = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Name: ");
        name = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Section: ");
        section = obj.nextLine();
        System.out.println("\n");        
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "update student set Name = ? , Username = ? , Password = ? , Section = ?  where Username = ? ";
                PreparedStatement ps = con.prepareStatement(s);
                
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, section);
                ps.setString(5, uname);
                
                ps.executeUpdate();
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ViewAttendance() {
        System.out.println("Enter RollNo: ");
        String rn = obj.nextLine();
        try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("select *from attendance where RollNo = ?");
                pst.setString(1, rn);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                String name = rs.getString(1);
                String r = rs.getString(2);
                String sec = rs.getString(3);
                int att = rs.getInt(4);
                    System.out.println(name+ " " + r + " " + sec + " " + att);
                }
                
                
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
    public void viewMarks(){
            System.out.println("Enter Rollno: ");
            String rollno = obj.nextLine();
            System.out.println("");
            System.out.println("Enter Assignment Number: ");
            int no = obj.nextInt();
        
        try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("select *from marksheet where AssignmentNo = ? and RollNo = ? ");
                pst.setInt(1, no);
                pst.setString(2 , rollno);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    String rn = rs.getString(1);
                    String sec = rs.getString(2);
                    int n = rs.getInt(3);
                    int m = rs.getInt(4);
                    System.out.println(rn + " " +sec+ " " +n+ " " +m);
                    
                }
                
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        

        
    }

        
    public void ViewAssignment(){
            
            System.out.println("Enter Section Name: ");
            String section = obj.nextLine();
            System.out.println("");
            System.out.println("Enter Assignment Number: ");
            int no = obj.nextInt();
        
        try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("select *from assignment where No = ? and Section = ? ");
                pst.setInt(1, no);
                pst.setString(2 , section);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                int num = rs.getInt(1);
                String cont = rs.getString(2);
                String sec = rs.getString(3);
                    System.out.println(num+ " " + cont + " " + sec);
                }
                
                
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        
    
}
}

class Teacher extends StudentManagementSystem{
    Scanner obj = new Scanner(System.in);
    String username;
    String password;
    String name;
    String course;
    
    public void Register(){

        
        int i;
        System.out.println("Enter Username: ");
        username = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Password: ");
        password = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Name: ");
        name = obj.nextLine();
        System.out.println("Enter Course: ");
        course = obj.nextLine();
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "Insert into teacher (Name,Username,Password,Course) values (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, course);
                ps.executeUpdate();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

        
    public void Login(){

        String username, password, str, uname = "",pword = "";
        System.out.println("Username: ");
        username = obj.nextLine();
        System.out.println("");
        System.out.println("Password: ");
        password = obj.nextLine();
        System.out.println("");   
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from teacher");
                
                while(rs.next()){
                     uname = rs.getString(2);
                     pword = rs.getString(3);
                }
                    if(username.equals(uname) && password.equals(pword)){
                        System.out.println("Login Successful!");
                        Menu(uname);
                    }
                    else{
                    System.out.println("Wrong!");
                }
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Menu(String uname){
        System.out.println("1. Check Details");
        System.out.println("2. Upload Assignment");
        System.out.println("3. Edit Details");
        System.out.println("4. Mark Attendance");
        System.out.println("5. Mark Assignment");
        System.out.println("Enter your choice: ");
        int choice = obj.nextInt();
        obj.nextLine();
        
        switch(choice){
            case 1:
                CheckDetails(uname);
                break;
            case 2:
                uploadAssignments();
                break;
            case 3:
                EditDetails(uname);
                break;
            case 4:
                MarkAttendance();
                break;
            case 5:
                addMarks();
                break;
            default:
                System.out.println("Error");
                
    }
            
        
    }

    public void addMarks(){
        String name;
        String rollno;
        String section;
        int asno;
        int marks;
        
        int i = 0;

        System.out.println("Enter Roll Number: ");
        rollno = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter Section: ");
        section = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter asno: ");
        asno = obj.nextInt();
        System.out.println("\n");
        System.out.println("Enter marks: ");
        marks = obj.nextInt();
        System.out.println("\n");

        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "Insert into marksheet (RollNo,Section,AssignmentNo,Marks) values (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(s);
                ps.setString(1, rollno);
                ps.setString(2, section);
                ps.setInt(3, asno);
                ps.setInt(4, marks);
                
                ps.executeUpdate();

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void uploadAssignments(){
        String  content, section;
        int no;
        System.out.println("Enter Assignment Number: ");
        no = obj.nextInt();
        obj.nextLine();
        System.out.println("Enter Assignment Details: ");
        System.out.println("");        
        content = obj.nextLine();
        System.out.println("Enter Section: ");
        System.out.println("");
        section = obj.nextLine();
        System.out.println("");
        
        
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "Insert into assignment (No,Content,Section) values (?,?,?)";
                PreparedStatement ps = con.prepareStatement(s);
                ps.setInt(1, no);
                ps.setString(2, content);
                ps.setString(3, section);
                ps.executeUpdate();
                

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
    }

    public void MarkAttendance() {
        System.out.println("Enter Student RollNo:");
        String rn = obj.nextLine();
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                
                PreparedStatement m = con.prepareStatement("UPDATE attendance SET Attendance = Attendance + 1 where RollNo =?");
                m.setString(1, rn);
                m.executeUpdate();
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }    
    
    public void EditDetails(String uname){
        
        
        
        int i = 0;
        String username;
        String password;
        String name;
        String rollno;
        String section;
        System.out.println("Enter New Username: ");
        username = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Password: ");
        password = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Name: ");
        name = obj.nextLine();
        System.out.println("\n");
        System.out.println("Enter New Course: ");
        course = obj.nextLine();
        System.out.println("\n");        
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                String s = "update teacher set Name = ? , Username = ? , Password = ? where Username = ? ";
                PreparedStatement ps = con.prepareStatement(s);
                
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, uname);
                
                ps.executeUpdate();
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void CheckDetails(String uname){
        try {
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sms" , "root" , "" );
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("select *from teacher where username = ?");
                pst.setString(1, uname);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                String name = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String course = rs.getString(4);
                    System.out.println(name+ " " + username + " " + password + " " + course);
                }
                
                
                
                
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }    
    
    
}

class main{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int ch;
        int choice;
        System.out.println("Welcome To Student Management System!");
        System.out.println("Enter 1 For Student: ");
        System.out.println("Enter 2 For Teacher: ");
         choice = obj.nextInt();
        System.out.println("Enter 1 For Login: ");
        System.out.println("Enter 2 For Registeration: ");
        ch = obj.nextInt();
        if(choice == 1){
        
        StudentManagementSystem a = new Students();
                
            if(ch == 1){
                a.Login();
            }
            else if(ch == 2){
                a.Register();
            }
        }
        
        if(choice == 2){
        StudentManagementSystem a = new Teacher();
            if(ch == 1){
                a.Login();
            }
            else if(ch == 2){
                a.Register();
            }
        
        }
        
    

        }
        
}