import java.sql.*;
import java.util.Scanner;

public class JDBC_Connection {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/DBNAME";
        String name="root";
        String passwd="root";




        Connection con=DriverManager.getConnection(url,name,passwd);
        System.out.println("Connection Established!!!");
int choice;
    do {
        System.out.println("======================================");
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");

        System.out.println("SELECT any Operation: ");
        System.out.println("1, Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6.Select By Course");
        System.out.println("7. Exit");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a choice : ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                add_student(con);
                break;
            case 2:
                view_all_students(con);
                break;
            case 3:
                search_student(con);
                break;
            case 4:
                update_student(con);
                break;
            case 5:
                delete_student(con);
                break;
            case 6:
                search_by_course(con);
                break;
            case 7:
                exit();
                break;
            default:
                System.out.println("invalid Choice!!!");

        }
    }while(choice != 7);







//        rs.next();
//        String result=rs.getString("name");
//        System.out.println("Name : "+ result);


        con.close();
        System.out.println("Connection Closed!!!");
    }

    public static  void add_student(Connection con) throws  SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        String sname=sc.nextLine();
        System.out.println("Enter email: ");
        String email=sc.nextLine();
        System.out.println("Enter age: ");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter course: ");
        String course=sc.nextLine();
        System.out.println("Enter marks: ");
        int marks=sc.nextInt();
        sc.nextLine();
        String query="insert into students values(?,?,?,?,?,?)";

        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1,id);
        st.setString(2,sname);
        st.setString(3,email);
        st.setInt(4,age);
        st.setString(5,course);
        st.setInt(6,marks);

        st.execute();

        st.close();
        System.out.println("Student data inserted successfully!!");

    }

    public static void view_all_students(Connection con) throws SQLException{
        String query="select * from students";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        System.out.print("ID - NAME -  EMAIL -      AGE -     COURSE -  MARKS");
        while(rs.next()){

            System.out.println();
            System.out.print(rs.getInt(1)+" - ");
            System.out.print(rs.getString(2)+" - ");
            System.out.print(rs.getString(3)+" - ");
            System.out.print(rs.getInt(4)+" - ");
            System.out.print(rs.getString(5)+" - ");
            System.out.print(rs.getInt(6));
            System.out.println();
        }
        st.close();
        con.close();
        System.out.println("Viewed Data Successfully!!!");

    }

    public static void search_student(Connection con) throws  SQLException{
        System.out.println("Enter Student  id:");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();

        String query="Select name from students where id=? ";
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();

        while(rs.next()){

            System.out.println("NAME :"+ rs.getString("name"));

        }
        st.execute();
        st.close();
        System.out.println("Search student successfully!!!");
    }

    public static void update_student(Connection con) throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new student name: ");
        String new_name=sc.nextLine();

        System.out.println("Enter student id you want to update student name? ");

        int id=sc.nextInt();


        String query="update students set name=? where id=?";
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,new_name);
        st.setInt(2,id);

        int rows=st.executeUpdate();

        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
        st.execute();
        st.close();
        System.out.println("Update student done!!!");
    }

    public static void delete_student(Connection con) throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student id you want to delete? ");
        int id=sc.nextInt();
        String query="delete from students where id=?";
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1,id);
        int rows=st.executeUpdate();
        if(rows > 1){
            System.out.println("Delete Operation Done Successfully");
        }else{
            System.out.println("Student ID not found!!");
        }
        st.execute();
        st.close();

        System.out.println("Updation Done!!!");
    }

    public  static void search_by_course(Connection con) throws  SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter course name for details: ");
        String course=sc.nextLine();
        String query="select * from students where course=?";
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,course);
        ResultSet rs=st.executeQuery();

        while (rs.next()){
            System.out.print("Id :" + rs.getInt(1)+" - ");
            System.out.print("Name :" + rs.getString(2)+" - ");
            System.out.print("Email :" + rs.getString(3)+" - ");
            System.out.print("Age :" + rs.getInt(4)+" - ");
            System.out.print("Course :" + rs.getString(5)+" - ");
            System.out.print("Marks :" + rs.getInt(6));
            System.out.println();
        }

        st.execute();
        st.close();
        System.out.println("Search By Course Done Successfully");

    }

    public  static  void exit(){
        System.out.println("Exited!!!");
        return;
    }




}
