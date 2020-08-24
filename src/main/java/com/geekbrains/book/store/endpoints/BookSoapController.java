package com.geekbrains.book.store.endpoints;

import com.geekbrains.book.store.exceptions.ResourceNotFoundException;
import com.geekbrains.book.store.generatedclasses.Book;
import com.geekbrains.book.store.generatedclasses.Genre;
import com.geekbrains.book.store.generatedclasses.GetBookRequest;
import com.geekbrains.book.store.generatedclasses.GetBookResponse;
import com.geekbrains.book.store.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Endpoint
public class BookSoapController {
    private static final String NAMESPACE_URI = "http://geekbrains.book.com/store/endpoints/books";
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        List<Book> books = response.getBook();
        if (request.getId() != null) {
            books.add(bookRepository.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("Book with id not found")));
        } else {
            books.addAll(bookRepository.findAll());
        }
        return response;
    }
}
