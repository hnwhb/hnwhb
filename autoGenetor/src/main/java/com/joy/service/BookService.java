package com.joy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joy.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 汪海滨
 * @since 2021-12-14
 */
public interface BookService extends IService<Book> {
    List<Book> listEntity();
    Book selecteone(int id);
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    IPage<Book> getPage(int currentPage,int pageSize);
    IPage<Book>getPage(int currentPage,int pageSize,Book book);


}
