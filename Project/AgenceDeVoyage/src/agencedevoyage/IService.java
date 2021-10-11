/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencedevoyage;

import agencedevoyage.configuration.database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author bourg
 */
public interface IService<T> {

    void ajouter(T t);

    boolean supprimer(T t);

    boolean modifier(T t);

    List<T> consulter();

    default void executeQuery(String query) {
        Connection conn = DBConnection.getInstance().getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
