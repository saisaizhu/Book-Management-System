package com.example.demo.mapper;

import com.example.demo.entity.books;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author group
 * @since 2022-12-06
 */
@Mapper
public interface BooksMapper extends BaseMapper<books> {

}
