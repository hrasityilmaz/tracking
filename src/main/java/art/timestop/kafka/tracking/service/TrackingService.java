package art.timestop.kafka.tracking.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import art.timestop.kafka.dispatch.DispatchPreparing;
import art.timestop.kafka.dispatch.message.TrackingStatusUpdated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackingService {

    private static final String TRACKING_STATUS_TOPIC = "tracking.status";
    private  final KafkaTemplate<String, Object> kafkaProducer;

    public void process(DispatchPreparing dispatchPreparing) throws Exception {
        log.info("Received dispatch preparing message : " + dispatchPreparing);

        TrackingStatusUpdated trackingStatusUpdated = TrackingStatusUpdated.builder()
                .orderId(dispatchPreparing.getOrderId())
                .trackingStatus(TrackingStatus.PREPARING)
                .build();
        kafkaProducer.send(TRACKING_STATUS_TOPIC, trackingStatusUpdated).get();
    }

}
