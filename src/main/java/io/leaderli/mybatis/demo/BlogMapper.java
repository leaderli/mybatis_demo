package io.leaderli.mybatis.demo;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Map<String,String>> selectBlog();
    int insertBlog(Map<String,Object> map);
}
