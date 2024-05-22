package com.api.renault.repository;

import com.api.renault.models.ChatModel;
import com.api.renault.models.RiskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatModel, Integer> {
}
