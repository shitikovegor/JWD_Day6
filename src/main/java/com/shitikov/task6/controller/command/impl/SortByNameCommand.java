package com.shitikov.task6.controller.command.impl;

import com.shitikov.task6.controller.command.Command;
import com.shitikov.task6.model.entity.Book;
import com.shitikov.task6.service.LibraryService;
import com.shitikov.task6.service.impl.LibraryServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByNameCommand implements Command {
    private static final String RESPONSE = "Books sorted by name";

    @Override
    public Map<String, List<Book>> execute(Map<String, String> parameters) {
        LibraryService libraryService = new LibraryServiceImpl();
        Map<String, List<Book>> response = new HashMap<>();

        List<Book> sortedBooks = libraryService.sortBooksByName();
        response.put(RESPONSE, sortedBooks);

        return response;
    }
}
