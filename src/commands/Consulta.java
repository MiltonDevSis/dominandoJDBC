package commands;

import db.Db;
import db.DbException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {

    public static void consultarUser(){

        // Declaração das variáveis

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

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
        finally {
            Db.closeStatement(stmt);
            Db.closeResultSet(rs);
            Db.closeConection();
        }
    }
}


