package com.api.renault.controllers;

import com.api.renault.nina.NinaIA;
import com.api.renault.models.NinaModel;
import com.api.renault.models.MessageModel;
import com.api.renault.repository.NinaRepository;
import com.api.renault.repository.MessageRepository;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import com.api.renault.util.JsonConverter;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/renault/nina/chat")
public class NinaController {

    @Autowired
    NinaRepository ninaRepository;
    @Autowired
    MessageRepository messageRepository;

    @GetMapping
    public ResponseEntity<Object> loadChat() {
        try {
            return SuccessResponse.success200(messageRepository.findAll());
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }

    @PostMapping("/create-chat")
    public ResponseEntity<Object> createChat(@RequestParam(name = "title") String title) {
        try {

            NinaModel ninaModel = new NinaModel(title);
            ninaRepository.save(ninaModel);

            return SuccessResponse.success200(ninaModel);
        } catch (Exception e) {
            System.out.println(e);
            return ErrorResponse.error500(e);
        }
    }

    @PostMapping("/send")
    public ResponseEntity<Object> sendMessage(@RequestParam(name = "query") String query,
                                              @RequestParam(name = "id_chat") Integer chatId,
                                              @RequestParam(name = "id_user") Integer idUser) {

        try {

            if (ninaRepository.existsById(chatId)) {
                String ninaJson = NinaIA.run(query);

                JsonNode ninaMessage = JsonConverter.convertToJson(ninaJson);

                MessageModel userMessage = new MessageModel(chatId, idUser, query);
                MessageModel iAMessage = new MessageModel(chatId, 0, ninaMessage.get("answer").asText());

                messageRepository.save(userMessage);
                messageRepository.save(iAMessage);

                return SuccessResponse.success200(iAMessage);
            }

            return ErrorResponse.error400("Não foi possivel encontrar o chat");
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }
}
