package com.joy.mapper;

import com.joy.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 汪海滨
 * @since 2021-12-14
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
