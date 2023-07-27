package com.goIt.Core5.forum;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InMemoryMessageStorage implements MessageStorage {
    // робимо клас сінглтоном

    private final static InMemoryMessageStorage INSTANCE = new InMemoryMessageStorage();

    private List<Message> messages = new CopyOnWriteArrayList<>();

    public static InMemoryMessageStorage getInstanse(){
        return INSTANCE;
    }

    private InMemoryMessageStorage(){

    }

    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

    @Override
    public void add(Message message) {
        messages.add(message);
    }

    @Override
    public void deleteById(String id) { // потрібно пройтись по списку знайти повідомлення і його видалити
        /*  List<Message> filtredMessage =  messages.stream() // проходимось по всім повідомленням
                .filter(it -> !it.getId().equals(id)) // фільтруємо їх
                .collect(Collectors.toList()); // збираємо до купи, до листа */
      messages =  messages.stream()
                .filter(it -> !it.getId().equals(id))
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
}
