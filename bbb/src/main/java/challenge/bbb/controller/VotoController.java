package challenge.bbb.controller;

import challenge.bbb.dto.VotoRequest;
import challenge.bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voto")
@RequiredArgsConstructor
public class VotoController {

    private final VotoService votoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processVote(@RequestBody VotoRequest request) {
        votoService.processVote(request);
    }
}
