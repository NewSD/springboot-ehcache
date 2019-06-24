package com.niu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by ami on 2019/6/24.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;
}
