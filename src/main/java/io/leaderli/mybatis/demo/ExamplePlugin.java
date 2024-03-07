package io.leaderli.mybatis.demo;


import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.awt.image.ByteLookupTable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class ExamplePlugin implements Interceptor {
    private Properties properties = new Properties();

    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object proceed = invocation.proceed();
        BlogMapper mapper = mappedStatement.getConfiguration().getMapper(BlogMapper.class, null);
        System.out.println(mapper.selectBlog());
        return proceed;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("-----------");
        return Interceptor.super.plugin(this);
    }
}
