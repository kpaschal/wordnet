package kpaschal.wordnet.common.database.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kpaschal.wordnet.common.script.ScriptReader;

/**
 *
 * @author
 */
public class JDBCUtils {

    public static boolean databaseExists(JDBCConnection conn, String dbName) throws SQLException {
        boolean rVal = false;
        DatabaseMetaData metaData = conn.getConnection().getMetaData();
        ResultSet resultSet = metaData.getCatalogs();
        while (resultSet.next()) {
            if (dbName.equals(resultSet.getString(1))) {
                rVal = true;
            }
        }
        return rVal;
    }

    public static void createDatabase(JDBCConnection connection, String dbName) {
        try (PreparedStatement stmt = connection.getConnection().prepareCall("CREATE DATABASE " + dbName)) {
            stmt.execute();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static void dropDatabaseIfExists(JDBCConnection connection, String dbName) {
        try (PreparedStatement stmt = connection.getConnection().prepareCall("DROP DATABASE IF EXISTS " + dbName)) {
            stmt.execute();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static int countRows(JDBCConnection connection, String table) {
        int rowsCount = 0;
        try (PreparedStatement stmt = connection.getConnection().prepareCall("SELECT count(*) FROM " + table)) {
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    rowsCount = res.getInt(1);
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return rowsCount;
    }

    public static void deleteFromTables(JDBCConnection connection, String... tables) {
        try {
            try (PreparedStatement preStmt = connection.getConnection().prepareStatement("DELETE FROM ?")) {
                for (String s : tables) {
                    preStmt.setString(1, s);
                    preStmt.execute();
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static List<String> executeSqlScript(JDBCConnection connection, File file, boolean autoCommit, boolean continueOnError) {
        List<String> errors = new ArrayList<String>();
        try {
            connection.getConnection().setAutoCommit(autoCommit);

            try (ScriptReader scriptReader = new ScriptReader(file)) {
                Iterator<String> it = scriptReader.iterator();
                while (it.hasNext()) {
                    try {
                        connection.getConnection().prepareStatement(it.next() + ";").execute();
                    } catch (SQLException ex) {
                        errors.add(ex.getMessage());
                        if (!continueOnError) {
                            break;
                        }
                    }
                }

            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }

            if (!autoCommit) {
                connection.getConnection().commit();
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
        return errors;
    }
}
