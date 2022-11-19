package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class NumberReceiverResultDto {

    private final UUID uuid;
    private final LocalDateTime drawDate;
    private final Set<Integer> userNumbers;
    private String message;

    public NumberReceiverResultDto(UUID uuid, LocalDateTime drawDate, Set<Integer> userNumbers, String message) {
        this.uuid = uuid;
        this.drawDate = drawDate;
        this.userNumbers = userNumbers;
        this.message = message;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

    public Set<Integer> getUserNumbers() {
        return userNumbers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
