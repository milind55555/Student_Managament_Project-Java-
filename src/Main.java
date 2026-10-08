import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws  Exception {
        String url="jdbc:mysql://localhost:3306/college";
        String uname="root";
        String passwd="root";
        String query="Select name from student where rollo =102; ";
        Connection con=DriverManager.getConnection(url,uname,passwd);
        System.out.println("Connection Established");
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        String result=rs.getString("name");
        System.out.println("Name: " +result);
        con.close();

        System.out.println("Connection Closed");
    }
}