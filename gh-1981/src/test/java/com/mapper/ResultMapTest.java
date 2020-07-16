package com.mapper;

import com.mapper.model.TestOrder;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;

import static org.junit.Assert.assertNotNull;

class ResultMapTest {

    private final Logger logger = LogManager.getLogger(ResultMapTest.class);
    
    @ClassRule
    public static OracleContainer oracle = new OracleContainer("oracleinanutshell/oracle-xe-11g");

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void startup() {
        oracle.start();
        XMLConfigBuilder configBuilder = new XMLConfigBuilder(ResultMapTest.class.getResourceAsStream("/SqlMapConfig.xml"));
        Configuration configuration = configBuilder.parse();
        Environment environment = new Environment("development", new JdbcTransactionFactory(),
                new UnpooledDataSource(oracle.getDriverClassName(),
                        oracle.getJdbcUrl(), oracle.getUsername(), oracle.getPassword()));
        configuration.setEnvironment(environment);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Test
    void test() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TestOrder order = sqlSession.selectOne("com.mapper.test.find");
            logger.debug("{}", order);
            assertNotNull(order);
        }
    }
}