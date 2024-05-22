package com.api.renault.controllers;

import com.api.renault.chat_ia.ChatIA;
import com.api.renault.models.ChatModel;
import com.api.renault.models.MessageModel;
import com.api.renault.repository.ChatRepository;
import com.api.renault.repository.MessageRepository;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import com.api.renault.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/renault/ia/chat")
public class ChatController {

    @Autowired
    ChatRepository chatRepository;
    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/create-chat")
    public ResponseEntity<Object> createChat(@RequestParam(name = "title") String title) {
        try {

            ChatModel chatModel = new ChatModel(title);

            chatRepository.save(chatModel);

            return SuccessResponse.success200(chatModel);
        } catch (Exception e) {
            System.out.println(e);
            return ErrorResponse.error500(e);
        }
    }

    @PostMapping("/send")
    public ResponseEntity<Object> sendMessage(@RequestParam(name = "query") String query,
                                              @RequestParam(name = "id_chat") Integer chatId,
                                              @RequestParam(name = "id_user") Integer idUser) throws IOException, InterruptedException {

        try {

            if (chatRepository.existsById(chatId)) {
                String iAAnswer = ChatIA.run(query);

                MessageModel userMessage = new MessageModel(chatId, idUser, query);
                MessageModel iAMessage = new MessageModel(chatId, 0, iAAnswer);

                messageRepository.save(userMessage);
                messageRepository.save(iAMessage);

                return SuccessResponse.success200(JsonConverter.convertToJson(iAAnswer));
            }

            return ErrorResponse.error400("Não foi possivel encontrar o chat");
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }
}
