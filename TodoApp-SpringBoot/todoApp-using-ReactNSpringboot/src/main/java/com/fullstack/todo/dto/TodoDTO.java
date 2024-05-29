package com.fullstack.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
