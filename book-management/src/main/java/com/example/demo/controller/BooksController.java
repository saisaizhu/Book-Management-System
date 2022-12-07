package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.QueryPage;
import com.example.demo.entity.books;
import com.example.demo.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @PostMapping("/change")//必须要在表里
    public boolean change(@RequestBody books book){
        return bookService.updateById(book);
    }
    //新增或修改
    @PostMapping("/saveOrchange")//在表里就修改，不在就添加
    public boolean saveOrchange(@RequestBody books book){
        return bookService.saveOrUpdate(book);
    }
    //删除
    @PostMapping("/delete")
    public boolean delete(Integer id){
        return bookService.removeById(id);
    }
    //查询(模糊、匹配)
    @PostMapping("/listP")//在表里就修改，不在就添加
    public List<books> listP(@RequestBody books book){
        LambdaQueryWrapper<books> lambdaQueryWrapper=new LambdaQueryWrapper();

        //TODO:这是根据name来匹配的，之后修改还要加作者匹配

        lambdaQueryWrapper.like(books::getName,book.getName());//like方法是模糊查询  eq方法是完全匹配
        //lambdaQueryWrapper.eq(books::getName,book.getName());
        return bookService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
   // public List<books> listPage(@RequestBody HashMap map){
    public List<books> listPage(@RequestBody QueryPage query){
        //System.out.println(query);

//        System.out.println("num="+query.getPageNum());
//        System.out.println("size="+query.getPageSize());

        HashMap param=query.getParam();
        String name=String.valueOf(param.get("name"));
        //System.out.println("id="+String.valueOf(param.get("id")));

        //System.out.println(map);
/*        LambdaQueryWrapper<books> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(books::getName,book.getName());//like方法是模糊查询  eq方法是完全匹配
        //lambdaQueryWrapper.eq(books::getName,book.getName());
        return bookService.list(lambdaQueryWrapper);*/
        //分页
        Page<books> page=new Page<>();
        page.setCurrent(query.getPageNum());//当前页
        page.setSize(query.getPageSize());//每页多少条

        LambdaQueryWrapper<books> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(books::getName,name);

        IPage result=bookService.page(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listPageC")
    public List<books> listPageC(@RequestBody QueryPage query){//自定义分页
        //System.out.println(query);

        System.out.println("num="+query.getPageNum());
        System.out.println("size="+query.getPageSize());

        HashMap param=query.getParam();
        String name=String.valueOf(param.get("name"));
        //分页
        Page<books> page=new Page<>();
        page.setCurrent(query.getPageNum());//当前页
        page.setSize(query.getPageSize());//每页多少条

        LambdaQueryWrapper<books> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(books::getName,name);

        //分页的mapper
        //IPage result=bookService.pageC(page);
        //sql自定义映射
        IPage result=bookService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }
}
