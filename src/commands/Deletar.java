package commands;

import db.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletar {

    public static void deletarUser(){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Db.getConection();
            String sql = "Delete from seller where id = ?";

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, 6);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("DONE! rows affected: " + rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Db.closeStatement(stmt);
            Db.closeConection();
        }
    }
}
