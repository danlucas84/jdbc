package dao;


import config.Database;
import model.User;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // rodzaje operacji
    //save
    //update
    //delate
    // findById
    //findAll


    private Database database = new Database();

    public User save(User user) throws SQLException {
        //insert
        // 1 pobierz polaczenie

        Connection connection = database.getConnection();

        // 2 napisz zapytanie zakomentowwano bo to jest niebezpieczne wywoluje sql injection

        //String sql = "insert into user (first_name, last_name, email)" +
        //"Values () ";
//user.getFirstName() + "," +
//user.getLastname() + "," +
//user.getEmail () + "," +
        // firstName = *; DROP DATABASE;"

        String sql = "INSERT INTO user (first_name, last_name, email) " +
                "VALUES (?,?,?)";

        // 3/ utworz obiekt PreparedStatement

        PreparedStatement statement = connection.prepareStatement(sql);
        // 4. uzupelnij parametry zapytania

        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());

        statement.executeUpdate();
        return user;
    }

    public void update(User user) throws SQLException {
Connection connection = database.getConnection();
String sql = "UPDATE user by first_name=?,last_name=?," + "email=?, where id=?");

PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1,user.getFirstName());
statement.setString(2,user.getLastName());
statement.setString(3,user.getEmail());


        while (result.next()) {
            int id = result.getInt("id");

            String firstName = result.getString("first_name");
            String lastName = result.getNString("last_name");
            String email = result.getString("email");

    }

    public void delete(int id) {



            while (result.next()) {
                int id = result.getInt("id");

                String firstName = result.getString("first_name");
                String lastName = result.getNString("last_name");
                String email = result.getString("email");
    }

    public User FindById(int id) throws SQLException  {
    Connection connection = database.getConnection();

    String sql = "SELECT id, first_name, last_name, email " + "FROM user where id=?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1,id);
        ResultSet result = statement.executeQuery();
        User user = null;

        while (result.next()) {
            id = result.getInt("id");

            String firstName = result.getString("first_name");
            String lastName = result.getNString("last_name");
            String email = result.getString("email");
            user = new User(id, firstName,lastName,email);
        }

        return user;
    }

    public List<User> findAll() throws SQLException {

        Connection connection  = database.getConnection();

        String sql = "SELECT id, first_name, last_name, email FROM user ";

        PreparedStatement statement = connection.prepareStatement(sql);
        //statement.setInt(List); pomijamy ten krok bo nie mamy obiektu ani listy ktrora tutaj zwracamy
        ResultSet result = statement.executeQuery();
        List<User> users = new ArrayList<>();

        while (result.next()) {
             int id = result.getInt("id");

            String firstName = result.getString("first_name");
            String lastName = result.getNString("last_name");
            String email = result.getString("email");
            users.add (new User(id, firstName,lastName, email));
        }


        return users;
    }


}
    }