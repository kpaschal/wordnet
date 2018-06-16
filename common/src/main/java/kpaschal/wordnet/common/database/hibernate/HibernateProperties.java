package kpaschal.wordnet.common.database.hibernate;

import java.util.Properties;

/**
 *
 * @author
 */
public class HibernateProperties {

    private Properties properties = new Properties();
    private static HibernateProperties instance = new HibernateProperties();

    public static HibernateProperties getInstance() {
        instance.getProperties().clear();
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public HibernateProperties setDriverClass(String val) {
        instance.getProperties().setProperty("hibernate.connection.driver_class", val);
        return instance;
    }

    public HibernateProperties setUrl(String url) {
        instance.getProperties().setProperty("hibernate.connection.url", url);
        return instance;
    }

    public HibernateProperties setUsername(String val) {
        instance.getProperties().setProperty("hibernate.connection.username", val);
        return instance;
    }

    public HibernateProperties setPassword(String val) {
        instance.getProperties().setProperty("hibernate.connection.password", val);
        return instance;
    }

    public HibernateProperties setShowSQL(Boolean val) {
        instance.getProperties().setProperty("hibernate.show_sql", val.toString());
        return instance;
    }

    public HibernateProperties setCharset(String val) {
        instance.getProperties().setProperty("hibernate.connection.charSet", val);
        return instance;
    }

    public HibernateProperties setCharsetEncoding(String val) {
        instance.getProperties().setProperty("hibernate.connection.characterEncoding", val);
        return instance;
    }

    public HibernateProperties setUseUnicode(Boolean val) {
        instance.getProperties().setProperty("hibernate.connection.useUnicode", val.toString());
        return instance;
    }

    public HibernateProperties setDialect(String val) {
        instance.getProperties().setProperty("hibernate.dialect", val);
        return instance;
    }

    public HibernateProperties setCurrentSessionContextClass(String val) {
        instance.getProperties().setProperty("hibernate.current_session_context_class", val);
        return instance;
    }

    public HibernateProperties setCacheProviderClass(String val) {
        instance.getProperties().setProperty("hibernate.cache.provider_class", val);
        return instance;
    }

    public HibernateProperties setOrderInserts(Boolean val) {
        instance.getProperties().setProperty("hibernate.order_inserts", val.toString());
        return instance;
    }

    public HibernateProperties setOrderUpdates(Boolean val) {
        instance.getProperties().setProperty("hibernate.order_updates", val.toString());
        return instance;
    }

    public HibernateProperties setBatchSize(Integer val) {
        instance.getProperties().setProperty("hibernate.jdbc.batch_size", val.toString());
        return instance;
    }

    public HibernateProperties setUseSecondLevelCache(Boolean val) {
        instance.getProperties().setProperty("hibernate.cache.use_second_level_cache", val.toString());
        return instance;
    }

    public HibernateProperties setUseQueryCache(Boolean val) {
        instance.getProperties().setProperty("hibernate.cache.use_query_cache", val.toString());
        return instance;
    }
}
