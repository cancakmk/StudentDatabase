import java.sql.*;

public class StudentDatabase {
    private static final String serverLink="sql4.freemysqlhosting.net";
    private static final String port="3306";
    private static final String databaseName="sql4451905";
    private static final String name="sql4451905";
    private static final String password="U481ZYuhNS";
    private static Connection c;

    static {
        try {
            c = DriverManager.getConnection("jdbc:mysql://"+serverLink+":"+port+"/"+databaseName,name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static  Statement st;

    static {
        try {
            st = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        StudentDatabase s=new StudentDatabase();
        s.getAllData();




















    }
    public  void addData(String name,String surname) throws SQLException {
        String query="INSERT INTO Student(name,surname) VALUES(?,?)";
        PreparedStatement pt=c.prepareStatement(query);
        pt.setString(1,name);
        pt.setString(2,surname);
        pt.executeUpdate();
        pt.close();
    }



    public  void getAllData() throws SQLException {
        System.out.println("***************************");
        ResultSet rs=st.executeQuery("SELECT * FROM Student");
        while (rs.next()){
            System.out.println("ID:"+rs.getInt("id")+" Ad:"+rs.getString("name")+" Soyad:"+rs.getString("surname"));
        }
        System.out.println("***************************");

}

public void updateData(String name,String surname,String newName,String newSurname) throws SQLException {

    String query="UPDATE Student SET name='"+newName+"'where name='"+name+"' ";
    String query1="UPDATE Student SET surname='"+newSurname+"'where surname='"+surname+"' ";
    st.executeUpdate(query);
   st.executeUpdate(query1);


}
    public  void deleteData(String name,String surname) throws SQLException {
        String query="DELETE FROM  Student where name="+name+"AND surname="+surname;
        PreparedStatement pt=c.prepareStatement(query);
        pt.setString(1,name);
        pt.setString(2,surname);
        pt.executeUpdate();
        pt.close();
    }
    public  void deleteData(int id) throws SQLException {
        String query="DELETE FROM Student where id="+id;
        PreparedStatement pt=c.prepareStatement(query);

        pt.executeUpdate();
        pt.close();
    }





}
