package others.demo.imagevalidate;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

public class JDBC {

    @Bean
    public void getconnect() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("");
        dataSource.setDriverClassName("");
        dataSource.setUsername("");
        dataSource.setPassword("");
        dataSource.setMaxActive(10);
        dataSource.setInitialSize(20);

    }

    // 借助spring的profile特性能够在运行时选择数据源
    @Profile("development")//开发数据源
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }
    @Profile("QA")//QA数据源
    @Bean
    public DataSource Data() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("");
        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
    @Profile("production")//生产环境配置
    @Bean
    public DataSource productDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpitterDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource)jndiObjectFactoryBean.getObject();
    }
    
    
}
