package kpaschal.wordnet.common.database.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author
 */
public interface IJDBCIDGenerator<T> {

    T generate(Connection connection, String table, String column) throws SQLException;
}
