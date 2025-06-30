package art.timestop.kafka.tracking.handler;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import art.timestop.kafka.dispatch.DispatchPreparing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DispatchTrackingHandler {
    
    @KafkaListener(
        id="dispatchTrackingConsumerClient",
        topics="dispatch.tracking",
        groupId="tracking.dispatch.tracking",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(DispatchPreparing dispatchPreparing) throws Exception{

    }
}
