package com.example.demo.controller;

import com.example.demo.form.BookForm;
import com.example.demo.form.EditBookForm;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    BookForm bookForm;

    @GetMapping("/book-list")
    public String bookList(Model model) {
        // serviceを使って、本の一覧をDBから取得する
        List<Book> bookList = bookService.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return "bookList";
    }

    @GetMapping("/book-create")
    public String createBook(Model model) {

        model.addAttribute("bookForm", new BookForm());

        return "add";
    }

    @PostMapping("/book-create")
    public String saveBook(@ModelAttribute @Validated BookForm bookForm, BindingResult result, Model model) {

        // バリデーションエラーの場合
        if(result.hasErrors()) {
            // 新規登録画面に遷移
            return "add";
        }
        // 本を登録する
        bookService.insert(bookForm);
        // 本の一覧表示画面にリダイレクト
        return "redirect:/book-list";
    }

    // 編集画面を表示する
    @GetMapping("/book-edit")
    public String editBook(Model model, EditBookForm editBook) {

        editBook = bookService.getOneBook(editBook.getId());
        model.addAttribute(editBook);

        return "edit";
    }

    // 本の情報を更新する
    @PostMapping("/book-edit")
    public String update(@ModelAttribute @Validated EditBookForm editBook, BindingResult result, Model model) {

        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 編集画面に遷移
            return "edit";
        }

        // 本を更新する
        bookService.update(editBook);

        // 本の一覧画面にリダイレクト
        return "redirect:/book-list";
    }

    // 本の削除を行う
    @GetMapping("/book-delete")
    public String deleteBook(Model model, Book Book) {

        // データベースのデータを削除する
        bookService.delete(Book.getId());

        // 本の一覧画面にリダイレクト
        return "redirect:/book-list";
    }
}