package pl.lotto.numberreceiver;

class NumberReceiverConfiguration {

    private final NumberReceiverRepository numberReceiverRepository;

    NumberReceiverConfiguration(NumberReceiverRepository numberReceiverRepository) {
        this.numberReceiverRepository = numberReceiverRepository;
    }

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        NumberReceiverDrawDate numberReceiverDrawDate = new NumberReceiverDrawDate();
        return new NumberReceiverFacade(numberValidator, numberReceiverDrawDate, numberReceiverRepository);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }


}
