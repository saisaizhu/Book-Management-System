package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.books;
import com.example.demo.mapper.BooksMapper;
import com.example.demo.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author group
 * @since 2022-12-06
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, books> implements IBooksService {

    @Resource
    private BooksMapper booksMapper;

    @Override
    public IPage pageC(IPage<books> page){
        return booksMapper.pageC(page);
    }

    @Override
    public IPage pageCC(IPage<books> page, Wrapper wrapper) {
        return booksMapper.pageCC(page,wrapper);
    }
}
