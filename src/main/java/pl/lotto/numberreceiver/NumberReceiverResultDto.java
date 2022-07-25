package pl.lotto.numberreceiver;

import java.util.Optional;
import java.util.UUID;

public record NumberReceiverResultDto(Optional<UUID> uuid, String message) {
}
