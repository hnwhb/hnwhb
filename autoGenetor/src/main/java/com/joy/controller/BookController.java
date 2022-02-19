package com.joy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joy.controller.utils.R;
import com.joy.entity.Book;
import com.joy.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 汪海滨
 * @since 2021-12-14
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/list1")
    //@RequestMapping("list")
    public R getAll(){
//        List<Book> list=bookService.list();
//        R r=new R(true,list);
//        return r;
        return new R(true,bookService.list());
    }
    @GetMapping("/getByid/{id}")
    public R getById(@PathVariable int id){
        return new R(true,bookService.selecteone(id));
    }

    @PostMapping("/add")
    public R save(@RequestBody Book book){
        boolean flag=bookService.save(book);
        return new R(flag,flag?"修改成功^_^!":"修改失败-_-!");
    }
    @PutMapping("/update")
    public R updata(@RequestBody Book book){
        System.out.println(book);
        boolean flag=bookService.update(book);
        return new R(flag,flag?"成功^_^":"失败-_-!");
    }

    @DeleteMapping("/del/{id}")
    public R delete(@PathVariable int id){
        //System.out.println("chuanrude :"+id);
        boolean flag=bookService.delete(id);
        return new R(flag,flag?"删除成功^_^!":"删除失败-_-!");
    }

//    @GetMapping("/list/{currentPage}/{pageSize}")
//    public R getAll(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page=bookService.getPage(currentPage,pageSize);
//        return new R(true,page);
//    }

    @GetMapping("/list/{currentPage}/{pageSize}")
    public R getAll(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page=bookService.getPage(currentPage,pageSize,book);
        return new R(true,page);
    }

}

