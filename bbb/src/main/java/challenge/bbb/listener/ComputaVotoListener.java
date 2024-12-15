package challenge.bbb.listener;

import challenge.bbb.dto.VotoRequest;
import challenge.bbb.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComputaVotoListener {

    private final VotoService votoService;

    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(VotoRequest request) {
        votoService.save(request);
    }

}
