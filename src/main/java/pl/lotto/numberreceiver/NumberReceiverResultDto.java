package pl.lotto.numberreceiver;

import java.util.Optional;
import java.util.UUID;

record NumberReceiverResultDto(Optional<UUID> uuid, String message) {
}
