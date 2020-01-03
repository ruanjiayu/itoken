package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/5  9:50
 * @Version: 0.0.1-SNAPSHOT
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
