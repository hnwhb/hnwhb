package com.joy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joy.entity.Book;
import com.joy.mapper.BookMapper;
import com.joy.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoGenetorApp {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookService bookService;
    @Test
    void contextLoads() {
        System.out.println("hello world!");
    }

    @Test
    void TestGetById(){
     //System.out.println(bookMapper.selectList(null));
        bookMapper.selectList(null);
    }

    @Test
    public void TestListBook(){
        System.out.println(bookService.selecteone(3));
    }

    @Test
    public void TestListBook2(){
        bookService.list();
    }

    @Test
    public void testSave(){
        Book book=new Book();
        book.setType("测试数据-第二次--4");
        book.setName("ceshi-mincheng");
        book.setDescription("sssssssssss-");
        bookService.save(book);
    }

    @Test
    public void testUpdate(){
        Book book=new Book();
        book.setId(6);
        book.setType("测试数据-更新");
        book.setName("ceshi-mincheng");
        book.setDescription("sss-测试更新");
        bookService.update(book);
    }

    @Test
    public void testDelete(){
        bookService.delete(6);
    }

    @Test
    public void testPage1(){
        IPage<Book> page=new Page<Book>(2,3);
        bookMapper.selectPage(page,null);
        System.out.println("总页数:  "+page.getPages());//总页数
        System.out.println("当前页数:   "+page.getCurrent());//当前页数
        System.out.println("每页条数:  "+page.getSize());//每页条数
        System.out.println("总记录数:  "+page.getTotal());//总记录数
        System.out.println("该页记录数据:  "+page.getRecords());//该页记录数据
    }

    @Test
    public void testPage2(){
        IPage<Book> page=new Page<Book>(2,3);
        bookService.page(page);
        System.out.println("总页数:  "+page.getPages());//总页数
        System.out.println("当前页数:   "+page.getCurrent());//当前页数
        System.out.println("每页条数:  "+page.getSize());//每页条数
        System.out.println("总记录数:  "+page.getTotal());//总记录数
        System.out.println("该页记录数据:  "+page.getRecords());//该页记录数据
    }

    @Test
    public void testGetby1(){
        QueryWrapper<Book> qw =new QueryWrapper<>();
        qw.like("name","直播");
        bookMapper.selectList(qw);
    }

    @Test //lamdba表达式
    public void testGetby2(){
        String name="直播";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        lqw.like(Book::getName,name);
        bookMapper.selectList(lqw);
    }

    @Test
    public void testGetby3(){
        String name="";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        //lqw.like((name!=null &&name!=""),Book::getName,name);
        lqw.like(Strings.isNotEmpty(name),Book::getName,name);
        bookMapper.selectList(lqw);
    }

    @Test
    public void getPage(){
        //int currentPage,pageSiza;
        IPage<Book>page= bookService.getPage(1,5);
        System.out.println(page.getRecords());
    }
}
