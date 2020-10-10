package commands;

import db.Db;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transferir {

    public static void transferir(){

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = Db.getConection();

            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            int rows1 = stmt.executeUpdate("update seller set BaseSalary = 2999 where DepartmentId = 1");
            int rows2 = stmt.executeUpdate("update seller set BaseSalary = 3999 where DepartmentId = 2");

            /*
            int x = 1;
            if (x < 2){
                throw new SQLException("Fake error");
            }
            */
            conn.commit();
            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);

        }catch (SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Cause by:" + e.getMessage());

            } catch (SQLException e1) {
                throw new DbException("cause by: " + e1.getMessage());
            }
        }finally {
            Db.closeStatement(stmt);
            Db.closeConection();
        }
    }
}
