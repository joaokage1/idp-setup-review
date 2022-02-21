package com.setup.review.game.validation.reviewer.service;

import com.setup.review.game.validation.reviewer.model.ValidationReviewer;
import com.setup.review.game.validation.reviewer.repository.ValidationReviewerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@AllArgsConstructor
public class ValidationReviewerService {

    private final ValidationReviewerRepository validationReviewerRepository;

    private static final String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public Boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);

        log.info("verificando: {}", email);
        boolean valido = matcher.matches();

        log.info("verificado: {}", valido);

        ValidationReviewer validationReviewer = ValidationReviewer.builder()
                .email(email)
                .valid(valido)
                .build();

        validationReviewerRepository.save(validationReviewer);
        return valido;
    }

    @Scheduled(cron = "0 0/2 * * * *")
    @SchedulerLock(name = "todosEmailsVerificados",
            lockAtLeastForString = "PT5S", lockAtMostForString = "PT10M")
    public void scheduledTask() {
        List<String> validationReviewerList = validationReviewerRepository.findAll().stream().map(validationReviewer -> validationReviewer.getEmail()).toList();
        log.info("Todos os emails verificados: {}", validationReviewerList);
    }
}
