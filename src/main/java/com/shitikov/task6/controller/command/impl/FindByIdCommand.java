package com.shitikov.task6.controller.command.impl;

import com.shitikov.task6.controller.command.Command;
import com.shitikov.task6.controller.command.type.KeyType;
import com.shitikov.task6.model.entity.Book;
import com.shitikov.task6.service.LibraryService;
import com.shitikov.task6.service.impl.LibraryServiceImpl;

import java.util.*;

public class FindByIdCommand implements Command {
    private static final String BOOK_NOT_FOUND_RESPONSE = "Book didn't find";

    @Override
    public Map<String, List<Book>> execute(Map<String, String> parameters) {
        LibraryService libraryService = new LibraryServiceImpl();
        Map<String, List<Book>> response = new HashMap<>();

        if (parameters.containsKey(KeyType.ID.getName())) {
            String id = parameters.get("id");
            Optional<Book> foundBook = libraryService.findById(id);

            if (foundBook.isPresent()) {
                List<Book> foundBooks = new ArrayList<>();
                foundBooks.add(foundBook.get());
                response.put(CommandService.FOUND_RESPONSE, foundBooks);
            } else {
                response.put(BOOK_NOT_FOUND_RESPONSE, new ArrayList<>());
            }
        }
        return response;
    }
}
