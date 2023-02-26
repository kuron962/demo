package com.example.demo.service;

import com.example.demo.form.BookForm;
import com.example.demo.form.EditBookForm;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * データベースにデータを登録する
     * @return
     */
    public void insert(BookForm fm) {
        // データベースに登録する値を保持するインスタンス
        Book book = new Book();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        book.setTitle(fm.getTitle());
        book.setPrice(fm.getPrice());

        // データベースに登録する
        bookRepository.save(book);
    }

    // 受け取ったidからデータを取得して、Formを返却する
    public EditBookForm getOneBook(Integer id) {

        // idを指定して本の情報を取得する
        Book book = bookRepository.findById(id).orElseThrow();

        // 画面返却用のFormに値を設定する
        EditBookForm editBook = new EditBookForm();
        editBook.setId(book.getId());
        editBook.setTitle(book.getTitle());
        editBook.setPrice(book.getPrice());

        return editBook;
    }

    // 本を更新する
    public void update(EditBookForm editBook) {

        // データベースに登録する値を保持するインスタンスの作成
        Book book = new Book();

        // 画面から受け取った値を設定する
        book.setId(editBook.getId());
        book.setTitle(editBook.getTitle());
        book.setPrice(editBook.getPrice());

        // データベースを更新する
        bookRepository.save(book);
    }

    // 本を削除する
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        bookRepository.deleteById(id);
    }
}
