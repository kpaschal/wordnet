package kpaschal.wordnet.common.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class JDBCIncrementIDGenerator implements IJDBCIDGenerator<Number> {

    @Override
    public Number generate(Connection connection, String table, String column) throws SQLException {
        long nextId = -1;
        PreparedStatement stmt = connection.prepareStatement("SELECT max(" + column + ") FROM " + table);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            nextId = res.getLong(1) + 1;
        }
        return nextId;
    }
}
