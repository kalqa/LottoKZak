package pl.lotto.numberreceiver;

class NumberReceiverConfiguration {

    NumberReceiverRepository numberReceiverRepository;

    public NumberReceiverConfiguration(NumberReceiverRepository numberReceiverRepository) {
        this.numberReceiverRepository = numberReceiverRepository;
    }

    public NumberReceiverConfiguration() {
    }

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        return new NumberReceiverFacade(numberValidator, numberReceiverRepository);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }


}
