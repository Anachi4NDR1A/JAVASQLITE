/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author ANDRIANANTENAINA
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = SQLiteConnection.connect();

        if (conn != null) {
            try {
                // Exemple : exécution d'une requête SELECT
                String query = "SELECT * FROM utilisateur";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Traitement des résultats
                        String col1Value = resultSet.getString("nom");
                        System.out.println(col1Value);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Fermer la connexion lorsque vous avez fini
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}

