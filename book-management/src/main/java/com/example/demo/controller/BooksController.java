package com.example.demo.controller;


import com.example.demo.entity.books;
import com.example.demo.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author group
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private IBooksService bookService;

    @GetMapping("/list")
    public List<books> show(){
        return bookService.list();
    }

    //新增
    @PostMapping("/save")//保存
    public boolean save(@RequestBody books book){
        return bookService.save(book);
    }
    //修改
    @PostMapping("/change")
    public boolean change(@RequestBody books book){
        return bookService.updateById(book);
    }
    //新增或修改
    @PostMapping("/saveOrchange")
    public boolean saveOrchange(@RequestBody books book){
        return bookService.saveOrUpdate(book);
    }
    //删除
    @PostMapping("/delete")
    public boolean delete(Integer id){
        return bookService.removeById(id);
    }
    //查询(模糊、匹配)

}
