package Wikiexercise;

import java.sql.*;

/**
 * Created by kenshin on 2/10/15.
 */
public class AppMySQL {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void processPices(ResultSet res)throws SQLException {
        while(res.next()!= null) {

            res.getString    (1);
            res.getInt     (2);
    }
    public void processProvides(ResultSet res)throws SQLException  {
        while(res.next()!= null) {

            res.getDouble(1);
            res.getInt(2);
        }
    public void processProviders(ResultSet res)throws SQLException  {
        while(res.next()!= null) {

            res.getString    (1);
            res.getString    (2);
        }

    public void main(String[] args) throws Exception {
        connect = DriverManager.getConnection("jdbc:mysql://localhost/WIKI?" + "user=sqluser&password=sqluserpw");
        statement = connect.createStatement();

        resultSet = statement.executeQuery(" SELECT Name FROM Pieces;");
        processPices(resultSet);
        resultSet = statement.executeQuery("  SELECT * FROM Providers;");
        processProviders(resultSet);
        resultSet = statement.executeQuery("   SELECT Piece, AVG(Price) FROM Provides\n" + "GROUP BY Piece;");
        processProvides(resultSet);
        resultSet = statement.executeQuery("   SELECT Providers.Name FROM Providers INNER JOIN Provides ON Providers.Code = Provides.Provider AND Provides.Piece = 1;");
        processProviders(resultSet);
        resultSet = statement.executeQuery("  SELECT Pieces.Name FROM Pieces INNER JOIN Provides ON Pieces.Code = Provides.Piece AND Provides.Provider = 'HAL';");
        processProviders(resultSet);
        resultSet = statement.executeQuery("  SELECT Pieces.Name, Providers.Name, Price FROM Pieces INNER JOIN Provides ON Pieces.Code = Piece INNER JOIN Providers ON Providers.Code = Provider WHERE Price =SELECT MAX(Price) FROM Provides WHERE Piece = Pieces.Code);");
        processPices(resultSet);
        resultSet = statement.executeQuery("  INSERT INTO Provides  VALUES (1, 'TNBC', 7);");
        processProvides(resultSet);
        resultSet = statement.executeQuery("  UPDATE Provides SET Price = Price + 1;");
        resultSet = statement.executeQuery(" DELETE FROM Provides WHERE Provider = 'RBT'  AND Piece = 4;");
        resultSet = statement.executeQuery(" DELETE FROM Provides WHERE Provider = 'RBT';");


    }
}
