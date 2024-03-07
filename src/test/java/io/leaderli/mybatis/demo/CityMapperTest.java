package io.leaderli.mybatis.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

class CityMapperTest {

    @Test
    void test() throws IOException {
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));

        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addInterceptor(new ExamplePlugin());


        SqlSession sqlSession = sqlSessionFactory.openSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("author_id", 3);
        map.put("title", "3");
        mapper.insertBlog(map);
        System.out.println(mapper.selectBlog());

    }

}
