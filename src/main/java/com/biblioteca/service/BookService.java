package com.biblioteca.service;

import com.biblioteca.domain.Book;
import com.biblioteca.domain.dtos.BookDTO;
import com.biblioteca.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookService {


    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookDTO save(BookDTO book){

        //CONVETER DTO PARA CLASSE ENTITY
        Book map = this.modelMapper.map(book, Book.class);

        //SALVA ENTITY
        Book save = this.bookRepository.save(map);

        //CONVERTE ENTITY PARA DTO
        return this.modelMapper.map(save, BookDTO.class);
    }


    public BookDTO getBook(Long id){
        Optional<Book> byId = this.bookRepository.findById(id);

        return this.modelMapper.map(byId.get(), BookDTO.class);

    }

    public List<BookDTO> getAllBooks(){

        return this.bookRepository.findAll()
                .stream()
                .map(book -> this.modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public void removeBook(Long id){

        Optional<Book> byId = this.bookRepository.findById(id);

        if (byId.isEmpty())
            throw new RuntimeException("Não existe");

        this.bookRepository.deleteById(id);
    }
}
