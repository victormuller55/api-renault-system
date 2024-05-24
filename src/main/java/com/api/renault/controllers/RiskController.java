package com.api.renault.controllers;

import com.api.renault.models.RiskModel;
import com.api.renault.repository.RiskRepository;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/renault/risks")
public class RiskController {

    @Autowired
    RiskRepository riskRepository;

    @PostMapping
    public ResponseEntity<Object> postRisk(@RequestBody RiskModel riskModel) {
        try {
            riskRepository.save(riskModel);
            return SuccessResponse.success200(riskModel);
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getRisks() {
        try {
            return SuccessResponse.success200(riskRepository.findAll());
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }


//    @GetMapping("/dashboard/counter")
//    public ResponseEntity<Integer> getTotalRisks() {
//        return SuccessResponse.success200(Math.toIntExact(riskRepository.count()));
//    }
//
//    @GetMapping("/dashboard/resolved")
//    public ResponseEntity<Integer> getResolvedRisks() {
//        Integer resolvedRisks = Math.toIntExact(riskRepository.countByStatus("Concluído"));
//        return SuccessResponse.success200(resolvedRisks);
//    }
//
//    @GetMapping("/dashboard/trajectory")
//    public ResponseEntity<List<RiskModel>> getTrajectory() {
//        List<RiskModel> trajectory = riskRepository.findByStatusOrderByResolutionDateAsc("Em progresso");
//        return SuccessResponse.success200(trajectory);
//    }
}
