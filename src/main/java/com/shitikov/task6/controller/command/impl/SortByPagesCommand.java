package com.shitikov.task6.controller.command.impl;

import com.shitikov.task6.controller.command.Command;
import com.shitikov.task6.controller.command.type.CommandResponse;
import com.shitikov.task6.model.entity.Book;
import com.shitikov.task6.service.LibraryService;
import com.shitikov.task6.service.impl.LibraryServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByPagesCommand implements Command {
    private static final String SORT_TYPE = "by number of pages";

    @Override
    public Map<String, List<Book>> execute(Map<String, String> parameters) {
        LibraryService libraryService = new LibraryServiceImpl();
        Map<String, List<Book>> response = new HashMap<>();

        List<Book> sortedBooks = libraryService.sortByPages();
        response.put(CommandResponse.SORT_RESPONSE.getMessage().concat(SORT_TYPE), sortedBooks);

        return response;
    }
}
