package nix.education.java.banking;

import java.sql.*;

public class Connect {

    private BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();
    private static final String URL = "jdbc:sqlite:card.s3db";
    private Connection connection = null;

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disconnect();
    }

    public String getStringValue(String where_column, String value_column, String return_column) {
        connect();
        String query = "SELECT *\n" +
                "FROM    card\n" +
                "WHERE   " + where_column + " = " + value_column + ";";
        String value = " ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            value = resultSet.getString(return_column);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disconnect();
        return value;
    }

    public int getIntValue(String where_column, String value_column, String return_column) {
        connect();
        String query = "SELECT *\n" +
                "FROM    card\n" +
                "WHERE   " + where_column + " = " + value_column + ";";
        int value = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            value = resultSet.getInt(return_column);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disconnect();
        return value;
    }

    public int getMaxId() {
        connect();
        String query = "SELECT MAX(id) FROM card;";
        int maxId = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            maxId = resultSet.getInt("MAX(id)");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disconnect();
        return maxId;
    }

    public void createCardTable() {
        connect();
        String query = "CREATE TABLE IF NOT EXISTS card (\n" +
                "   id INTEGER PRIMARY KEY, \n" +
                "   number TEXT NOT NULL,\n" +
                "   pin TEXT NOT NULL,\n" +
                "   balance INTEGER DEFAULT 0)";
        setQuery(query);
    }

    public void insertCard(int id, String number, String pin, int balance) {
        connect();
        String query = "INSERT INTO card(id, number, pin, balance) VALUES(" + id + ", " + number + ", " + pin + ", " + balance + ")";
        setQuery(query);
    }

    public void increaseBalance(String user_inn, int value) {

        connect();

        value += getIntValue(bankingSystemConstants.NUMBER_COLUMN, user_inn, bankingSystemConstants.BALANCE_COLUMN);

        String query = "UPDATE card\n" +
                "SET balance = " + value + "\n" +
                "WHERE number = " + user_inn + ";";

        setQuery(query);
    }

    public void decreaseBalance(String user_inn, int value) {

        connect();
        value = getIntValue(bankingSystemConstants.NUMBER_COLUMN, user_inn, bankingSystemConstants.BALANCE_COLUMN) - value;

        String query = "UPDATE card\n" +
                "SET balance = " + value + "\n" +
                "WHERE number = " + user_inn + ";";

        setQuery(query);
    }

    public void removeAccount(String account_number) {

        connect();
        String query = "DELETE FROM card\n" +
                "where number = " + account_number + ";";

        setQuery(query);
    }
}