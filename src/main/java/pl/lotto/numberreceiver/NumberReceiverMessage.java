package pl.lotto.numberreceiver;

public enum NumberReceiverMessage {
    VALIDATE_OK("OK"),ERROR_QUANTITY_NUMBER("Wrong number of numbers"),
    ERROR_LIMIT_VALUE_NUMBER("Number not in limits");

    private final String message;

    NumberReceiverMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
