package commands;

import db.Db;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Inserir {

    public static void inserirUsuarios(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = Db.getConection();

            String sql = "insert into seller (Name, Email, BirthDate, BaseSalary, DepartmentId) values (?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, "José bonifacil");
            stmt.setString(2, "jose@gmail.com");
            stmt.setDate(3, new Date(sdf.parse("15/12/1989").getTime()));
            stmt.setDouble(4,500.00);
            stmt.setInt(5, 1);

            int rowsAffected = stmt.executeUpdate();

           System.out.println("Done, Rows affected: " + rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }finally {
            Db.closeStatement(stmt);
            Db.closeConection();
        }
    }
}
