package top.pixcer.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.util.StringUtils;
import top.pixcer.service.OptionService;
import top.pixcer.util.SystemUtil;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;

/**
 * Created by HectorPu
 * on 2022/9/10 14:12 <hr/>
 * Desc：
 **/
@Slf4j
@Configuration
@EnableJpaRepositories
@ComponentScan(basePackages = "top.pixcer")
@Import(cn.hutool.extra.spring.SpringUtil.class)
@PropertySource("classpath:application.properties")
public class SpringConfig {
    /**
     * application datasource default db name ...
     *
     * db directory is datasource, so db name is bugTool
     */
    private final static String DATA_SOURCE_NAME = "dataSource/bugTool";

    @Bean
    @DependsOn("defaultInitService")
    public DataSource dataSource(OptionService optionService){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .ignoreFailedDrops(true)
                .setDataSourceFactory(new DataSourceFactory() {
                    @Override
                    public ConnectionProperties getConnectionProperties() {
                        log.info("create connection properties ...");
                        return new ConnectionProperties() {
                            @Override
                            public void setDriverClass(Class<? extends Driver> driverClass) {

                            }

                            @Override
                            public void setUrl(String url) {

                            }

                            @Override
                            public void setUsername(String username) {

                            }

                            @Override
                            public void setPassword(String password) {

                            }
                        };
                    }

                    @Override
                    public DataSource getDataSource() {
                        JdbcDataSource jdbcDataSource = new JdbcDataSource();
                        Path dataSource = Paths.get(optionService.getWorkSpace(), DATA_SOURCE_NAME);
                        String normal = SystemUtil.normalWorkspacePath(dataSource.toUri().getPath());
                        String dataSourcePath = "jdbc:h2:file:" + normal;
                        log.info("create database, database path is {} !",dataSourcePath);
                        jdbcDataSource.setUrl(dataSourcePath);
                        return jdbcDataSource;
                    }
                })
                .setName("bugTool")
                .setScriptEncoding("UTF-8")
                .addScript("classpath:script/schema.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    @Bean
//    EntityManagerFactory entityManagerFactory() {
//        // …
//        org.springframework.orm.jpa
//    }
}
