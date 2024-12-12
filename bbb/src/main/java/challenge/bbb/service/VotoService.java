package challenge.bbb.service;

import challenge.bbb.dto.VotoRequest;
import challenge.bbb.entity.Candidato;
import challenge.bbb.entity.Voto;
import challenge.bbb.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final RabbitTemplate rabbitTemplate;

    private final VotoRepository votoRepository;

    public void processVote(VotoRequest request) {
        rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
    }

    public void save(VotoRequest request) {
        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        voto.setDataHora(LocalDateTime.now());

        votoRepository.save(voto);
    }
}
