package com.api.renault.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_risk")
public class RiskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer idRisk;

    @JsonProperty("risk")
    private String risk;

    @JsonProperty("risk_type")
    private String riskType;

    @JsonProperty("area_responsible_for_identification")
    private String areaResponsibleForIdentification;

    @JsonProperty("risk_delivery_date")
    private String riskDeliveryDate;

    @JsonProperty("impact_consequence")
    private String impactConsequence;

    @JsonProperty("project")
    private String project;

    @JsonProperty("metier")
    private String metier;

    @JsonProperty("jalon_affected")
    private String jalonAffected;

    @JsonProperty("jalon_affected_in_future")
    private String jalonAffectedInFuture;

    @JsonProperty("probability")
    private String probability;

    @JsonProperty("impact")
    private String impact;

    @JsonProperty("risk_classification")
    private String riskClassification;

    @JsonProperty("renault_impact")
    private String renaultImpact;

    @JsonProperty("strategy")
    private String strategy;

    @JsonProperty("action")
    private String action;

    @JsonProperty("pilot_name")
    private String pilotName;

    @JsonProperty("pilot_id")
    private String pilotId;

    @JsonProperty("action_plan_start")
    private String actionPlanStat;

    @JsonProperty("alert_date")
    private Date alertDate;

    @JsonProperty("resolution_time")
    private Integer resolutionTime;

    @JsonProperty("hora")
    private String hour;

    @JsonProperty("commentary")
    private String commentary;

    @JsonProperty("residual_probability")
    private String residualProbability;

    @JsonProperty("residual_risk_classification")
    private String residualRiskClassification;

    @JsonProperty("action_validation")
    private String actionValidation;

    @JsonProperty("risk_validation")
    private String riskValidation;

    @JsonProperty("resolution_date")
    private Date resolutionDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("capitalization")
    private boolean capitalization;


    public Integer getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(Integer idRisk) {
        this.idRisk = idRisk;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getAreaResponsibleForIdentification() {
        return areaResponsibleForIdentification;
    }

    public void setAreaResponsibleForIdentification(String areaResponsibleForIdentification) {
        this.areaResponsibleForIdentification = areaResponsibleForIdentification;
    }

    public String getRiskDeliveryDate() {
        return riskDeliveryDate;
    }

    public void setRiskDeliveryDate(String riskDeliveryDate) {
        this.riskDeliveryDate = riskDeliveryDate;
    }

    public String getImpactConsequence() {
        return impactConsequence;
    }

    public void setImpactConsequence(String impactConsequence) {
        this.impactConsequence = impactConsequence;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getJalonAffected() {
        return jalonAffected;
    }

    public void setJalonAffected(String jalonAffected) {
        this.jalonAffected = jalonAffected;
    }

    public String getJalonAffectedInFuture() {
        return jalonAffectedInFuture;
    }

    public void setJalonAffectedInFuture(String jalonAffectedInFuture) {
        this.jalonAffectedInFuture = jalonAffectedInFuture;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getRiskClassification() {
        return riskClassification;
    }

    public void setRiskClassification(String riskClassification) {
        this.riskClassification = riskClassification;
    }

    public String getRenaultImpact() {
        return renaultImpact;
    }

    public void setRenaultImpact(String renaultImpact) {
        this.renaultImpact = renaultImpact;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }

    public String getActionPlanStat() {
        return actionPlanStat;
    }

    public void setActionPlanStat(String actionPlanStat) {
        this.actionPlanStat = actionPlanStat;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public Integer getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(Integer resolutionTime) {
        this.resolutionTime = resolutionTime;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getResidualProbability() {
        return residualProbability;
    }

    public void setResidualProbability(String residualProbability) {
        this.residualProbability = residualProbability;
    }

    public String getResidualRiskClassification() {
        return residualRiskClassification;
    }

    public void setResidualRiskClassification(String residualRiskClassification) {
        this.residualRiskClassification = residualRiskClassification;
    }

    public String getActionValidation() {
        return actionValidation;
    }

    public void setActionValidation(String actionValidation) {
        this.actionValidation = actionValidation;
    }

    public String getRiskValidation() {
        return riskValidation;
    }

    public void setRiskValidation(String riskValidation) {
        this.riskValidation = riskValidation;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCapitalization() {
        return capitalization;
    }

    public void setCapitalization(boolean capitalization) {
        this.capitalization = capitalization;
    }
}
