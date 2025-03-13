package com.mockbanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mock_banking_app_api";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void save(Account account) throws SQLException {

        String sql = "INSERT INTO accounts (id, balance) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, account.getId());
            statement.setInt(2, account.getBalance());

            int rowsChanged = statement.executeUpdate();

            if (rowsChanged == 0) throw new SQLException("Account not saved");

        } catch (SQLException e) {

            System.err.println("Cannot connect: " + e.getMessage());
            throw new SQLException();

        }
    }

    public void updateBalance(Account account) throws SQLException {

        String sql = "UPDATE accounts SET balance = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, account.getBalance());
            statement.setInt(2, account.getId());

            int rowsChanged = statement.executeUpdate();

            if (rowsChanged == 0) throw new SQLException("Balance not updated");

        } catch (SQLException e) {

            System.err.println("Cannot connect: " + e.getMessage());
            throw new SQLException();

        }
    }

    public Account getById(int id) throws SQLException {

        String sql = "SELECT * FROM accounts WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) return new CurrentAccount(resultSet.getInt("id"), resultSet.getInt("balance"));
            else throw new SQLException("Account not found");

        } catch (SQLException e) {

            System.err.println("Cannot connect: " + e.getMessage());
            throw new SQLException();

        }
    }
}