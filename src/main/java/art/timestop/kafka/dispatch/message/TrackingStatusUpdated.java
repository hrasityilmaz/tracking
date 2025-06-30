package art.timestop.kafka.dispatch.message;

import java.util.UUID;

import art.timestop.kafka.tracking.service.TrackingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackingStatusUpdated {
    UUID orderId;
    TrackingStatus trackingStatus;
}
