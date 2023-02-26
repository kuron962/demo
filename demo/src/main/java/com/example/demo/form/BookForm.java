package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookForm {

    /**
     * 本のタイトルを保持する
     */
    @NotBlank(message="タイトルを入力してください。")
    private String title;

    /**
     * 本の値段を保持する
     */
    @NotNull(message="値段を入力してください。")
    @Positive(message="値段はプラスの値を入力してください。")
    private Integer price;
}
