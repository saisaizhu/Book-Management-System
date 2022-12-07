package com.example.demo.service.impl;

import com.example.demo.entity.books;
import com.example.demo.mapper.BooksMapper;
import com.example.demo.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
