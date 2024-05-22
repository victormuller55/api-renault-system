package com.api.renault.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "messages")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer messageId;

    @JsonProperty("chat_id")
    private Integer chatId;

    @JsonProperty("id_renault_user")
    private Integer idRenaultUser;

    @JsonProperty("content")
    private String content;

    @JsonProperty("time_sent")
    private Date timeSent;

    // Construtor padrão necessário para JPA
    public MessageModel() {
    }

    // Construtor com parâmetros
    public MessageModel(Integer chatId, Integer idRenaultUser, String content) {
        this.chatId = chatId;
        this.idRenaultUser = idRenaultUser;
        this.content = content;
        this.timeSent = new Date();  // Inicializa com a data atual, se desejado
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getIdRenaultUser() {
        return idRenaultUser;
    }

    public void setIdRenaultUser(Integer idRenaultUser) {
        this.idRenaultUser = idRenaultUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }
}
