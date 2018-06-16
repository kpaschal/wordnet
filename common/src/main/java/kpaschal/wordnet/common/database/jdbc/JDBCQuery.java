package kpaschal.wordnet.common.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class JDBCQuery implements AutoCloseable{

    private Connection conn_;
    private String query_;
    private PreparedStatement preStmt_;
    private ResultSet resultSet_;

    public JDBCQuery(Connection conn, String query) {
        conn_ = conn;
        query_ = query;
        preStmt_ = null;
        resultSet_ = null;
    }

    public PreparedStatement getStatement() throws SQLException {
        if (null == preStmt_) {
            preStmt_ = conn_.prepareStatement(query_);
        }
        return preStmt_;
    }

    public ResultSet getResultSet() {
        return resultSet_;
    }

    public ResultSet execute() throws SQLException {
        if (preStmt_.execute()) {
            resultSet_ = preStmt_.getResultSet();
        } else {
            resultSet_ = null;
        }
        return resultSet_;
    }

    public ResultSet executeQuery() throws SQLException {
        return (resultSet_ = preStmt_.executeQuery());
    }

    public int executeUpdate() throws SQLException {
        return preStmt_.executeUpdate();
    }

    public boolean isExecuted() {
        return resultSet_ != null;
    }

    @Override
    public void close() {
        if (null != resultSet_) {
            try {
                resultSet_.close();
            } catch (SQLException ex) {
            }
        }
        if (null != preStmt_) {
            try {
                preStmt_.close();
            } catch (SQLException ex) {
            }
        }
    }
}
