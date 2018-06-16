package kpaschal.wordnet.common.database.jdbc;

import java.util.Objects;

/**
 *
 * @author
 */
public class JDBCConfiguration {

    private String driverClass;
    private String dbVendor;
    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String passWord;

    public JDBCConfiguration() {
    }

    public JDBCConfiguration(String driverClass, String dbVendor, String host, String port, String dbName, String userName, String passWord) {
        this.driverClass = driverClass;
        this.dbVendor = dbVendor;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.passWord = passWord;
    }
 
    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDbVendor() {
        return dbVendor;
    }

    public void setDbVendor(String dbVendor) {
        this.dbVendor = dbVendor;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    
    public String getUrl(){
        return new StringBuilder().append("jdbc:").append(dbVendor).append("://")
                .append(host).append(":").append(port)
                .append("/").append(dbName).toString();
    }
     
}
