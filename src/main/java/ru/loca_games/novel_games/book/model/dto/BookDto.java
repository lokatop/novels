package ru.loca_games.novel_games.book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class BookDto {
    @NotBlank
    @Size(min = 2, max = 255)
    private String name;
    @NotBlank
    @Size(min = 2, max = 255)
    private String description;
    @NotBlank
    @Size(min = 2, max = 255)
    private String author;
}
