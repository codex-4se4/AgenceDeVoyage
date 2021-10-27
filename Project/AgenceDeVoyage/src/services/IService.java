/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author bourg
 */
public interface IService<T> {

    void ajouter(T t);

    boolean supprimer(T t);

    boolean modifier(T t);

    ObservableList<T> consulter();

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
