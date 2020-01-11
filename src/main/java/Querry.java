import java.sql.*;

public class Querry {

    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;


    public void getUsers() {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ksiegarnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "sdatest";
        String password = "Start123!";
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM uzytkownik");
        while (resultSet.next())
        {
            Integer id = resultSet.getInt("id");
            String imie = resultSet.getString("imie");
            String nazwisko = resultSet.getString("nazwisko");
            System.out.println(id+" "+imie+" "+nazwisko);
        }
    }catch (ClassNotFoundException e)
    {
        e.printStackTrace();
    }catch (SQLException e)
    {
        e.printStackTrace();
    }
}

    public void getBooks() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ksiegarnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "sdatest";
            String password = "Start123!";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ksiazka");
            while (resultSet.next())
            {
                Integer id = resultSet.getInt("id");
                String tytul = resultSet.getString("tytul");
                System.out.println(id+" "+tytul);
            }
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getUsersByName(String name)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ksiegarnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "sdatest";
            String password = "Start123!";
            connection=DriverManager.getConnection(url,user,password);
            preparedStatement=connection.prepareStatement("SELECT * FROM uzytkownik WHERE imie =\""+name+"\"");
            boolean isResultSet = preparedStatement.execute();
            if(isResultSet) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    Integer id =resultSet.getInt("id");
                    String imie = resultSet.getString("imie");
                    String nazwisko = resultSet.getString("nazwisko");
                    System.out.println(id+" "+imie+" "+nazwisko);
                }
            }

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
