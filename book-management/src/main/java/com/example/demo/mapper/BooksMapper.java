package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.entity.books;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    IPage pageC(IPage<books> page);

    IPage pageCC(IPage<books> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
