package pl.lotto.resultannouncer;

enum ResultAnnouncerMessage {

    WIN_MESSAGE("Congratulations, Yoo win"), LOST_MESSAGE("Sorry, You lost");

    private final String message;

    ResultAnnouncerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
