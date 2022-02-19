package com.joy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joy.entity.Book;
import com.joy.mapper.BookMapper;
import com.joy.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 汪海滨
 * @since 2021-12-14
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> listEntity() {
        return bookMapper.selectList(null);
    }

    @Override
    public Book selecteone(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        bookMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {

        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page=new Page(currentPage,pageSize);
        bookMapper.selectPage(page,lqw);
        return page;
    }
}
