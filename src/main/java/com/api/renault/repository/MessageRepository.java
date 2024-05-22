package com.api.renault.repository;

import com.api.renault.models.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageModel, Integer> {
}
