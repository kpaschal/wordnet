package kpaschal.wordnet.common.database.jdbc;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class JDBCConnection implements Closeable {

    private Connection connection;
    private JDBCConfiguration dbConfig;

    public JDBCConnection(String driverClass, String dbVendor, String host, String port, String dbName, String userName, String passWord) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        this(new JDBCConfiguration(driverClass, dbVendor, host, port, dbName, userName, passWord));
    }

    public JDBCConnection(JDBCConfiguration dbConfig) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        this.dbConfig = dbConfig;
        openConnection();
    }

    public Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed() || !connection.isValid(0)) {
                this.openConnection();
            }
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            throw new IllegalStateException(ex);
        }
        return connection;
    }

    @Override
    public void close() {
        if (connection!= null) {
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }

    private void openConnection() throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        connection = DriverManager.getConnection(dbConfig.getUrl(),dbConfig.getUserName(),dbConfig.getPassWord());
    }

    public JDBCQuery createQuery(String sql) {
        return new JDBCQuery(connection, sql);
    }
}
