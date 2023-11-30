package se.miun.whiteboiz;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequestScoped
@Named
public class DatabaseExample {

    @Resource(lookup = "jdbc/LocalSqlResource")
    private DataSource dataSource;

    private String name;
    private int id;



    public void fetchDataFromDatabase() {
        try (Connection connection = dataSource.getConnection()) {
            // Your database operations using the connection
            // For example, execute a query
            String sql = "SELECT * FROM users";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Process each row of the result set
                    id = resultSet.getInt("id");
                    name = resultSet.getString("name");
                    // ... process other columns
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

