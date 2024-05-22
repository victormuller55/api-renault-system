package com.api.renault.repository;

import com.api.renault.models.RiskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RiskRepository extends JpaRepository<RiskModel, Integer> {
    Long countBy();

    @Query("SELECT COUNT(r) FROM RiskModel r WHERE r.riskClassification = :classification")
    Long countByRiskClassification(String classification);

    Long countByStatus(String status);

    List<RiskModel> findByStatusOrderByResolutionDateAsc(String status);

    List<RiskModel> findByImpact(String impact);

    List<RiskModel> findByProbability(String probability);

    List<RiskModel> findByAreaResponsibleForIdentification(String area);

    @Query("SELECT r FROM RiskModel r WHERE r.status = :status ORDER BY r.alertDate DESC")
    List<RiskModel> findByStatusOrderByAlertDateDesc(String status);
}
