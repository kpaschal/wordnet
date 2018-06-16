package kpaschal.wordnet.common.database.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

/**
 *
 * @author
 */
public class EnumUserType implements EnhancedUserType, ParameterizedType {

    public EnumUserType() {
    }
    private Class<Enum> enumClass;

    @Override
    public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty("enumClassName");
        try {
            enumClass = (Class<Enum>) Class.forName(enumClassName);
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe);
        }
    }

    @Override
    public String objectToSQLString(Object value) {
        return '\'' + ( (Enum) value ).name() + '\'';
    }
 
    @Override
    public String toXMLString(Object value) {
        return ( (Enum) value ).name();
    } 

    @Override
    public Object fromXMLString(String xmlValue) {
        return Enum.valueOf(enumClass, xmlValue);

    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return enumClass;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor arg2, Object owner) throws HibernateException, SQLException {
        String name = rs.getString( names[0] );
        return rs.wasNull() ? null : Enum.valueOf(enumClass, name);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor arg3) throws HibernateException, SQLException {
        if (value==null) {
            st.setNull(index, Types.VARCHAR);
        }
        else {
            st.setString( index, ( (Enum) value ).name() ); 
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}