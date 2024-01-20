package com.biblioteca.domain.dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {

    private Long id;

    private String author;

    private String name;

    private LocalDate dateRelease;
}
