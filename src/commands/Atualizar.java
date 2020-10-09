package commands;

import db.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Atualizar {

    public static void atualizarUser(){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Db.getConection();

            String sql = "update seller set BaseSalary = BaseSalary + ? where (DepartmentId = ?)";

            stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, 700.00);
            stmt.setInt(2, 1);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("DONE! Rows affected: " + rowsAffected);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Db.closeStatement(stmt);
            Db.closeConection();
        }
    }
}
