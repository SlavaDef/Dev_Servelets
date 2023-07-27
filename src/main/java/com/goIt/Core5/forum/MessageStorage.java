package com.goIt.Core5.forum;

import java.util.List;

public interface MessageStorage { // інтерфейс задаe поведінку зберігання повідомлень

    List<Message> getAllMessages();
    void add(Message message);
    void deleteById(String id);
}
