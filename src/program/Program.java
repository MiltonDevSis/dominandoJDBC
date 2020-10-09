package program;

import db.Db;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {

        // Declaração das variáveis
        Connection conn;
        Statement stmt;
        ResultSet rs;

        try {
            conn = Db.getConection();

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + " , " + rs.getString("Name"));
            }
        }catch (DbException | SQLException e){
            e.printStackTrace();
        }
    }
}
