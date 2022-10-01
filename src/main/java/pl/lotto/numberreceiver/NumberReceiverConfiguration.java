package pl.lotto.numberreceiver;

class NumberReceiverConfiguration {

    private NumberReceiverRepository numberReceiverRepository;

    NumberReceiverConfiguration(NumberReceiverRepository numberReceiverRepository) {
        this.numberReceiverRepository = numberReceiverRepository;
    }

    NumberReceiverConfiguration() {
    }

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        return new NumberReceiverFacade(numberValidator, numberReceiverRepository);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }


}
