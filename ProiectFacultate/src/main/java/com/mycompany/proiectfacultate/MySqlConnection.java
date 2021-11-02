package com.mycompany.proiectfacultate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
    static private Connection conn = null;
    static private MySqlConnection mySqlConnection = null;
    
    private MySqlConnection() {
        try {
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?user=root&password=root", "root","root");
            System.out.println("Connection to db succesful");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLStaLException: \" + ex.getMessage());\n" +
"            System.out.println(\"SQLStte: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public void createUser(NewUser user) {
        try {
        PreparedStatement Pstatement=conn.prepareStatement("insert into user values(?,?,?,?)");
        Pstatement.setString(1,user.getNume());
        Pstatement.setString(2,user.getParola());
        Pstatement.setString(3,user.getEmail());
        Pstatement.setString(4,user.getPozitie());
        Pstatement.executeUpdate();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    public NewUser findUser(String email, String parola) {
        try {
        PreparedStatement Pstatement = conn.prepareStatement("SELECT * FROM user WHERE email=? and parola=?");
        Pstatement.setString(1, email);
        Pstatement.setString(2, parola);
        ResultSet rs = Pstatement.executeQuery();
        rs.next();
        String nume = rs.getString("nume");
        String emailDB = rs.getString("email");
        String parolaDB = rs.getString("parola");
        String pozitie = rs.getString("pozitie");
        return new NewUser(nume,parola,email,pozitie);
      }
      catch (Exception e){
        return null;
      }
    }
    
        public static MySqlConnection getInstance()
    {
        if (mySqlConnection == null)
            mySqlConnection = new MySqlConnection();
        return mySqlConnection;
    }
}
