package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        NumberReceiverService numberReceiverService = new NumberReceiverService();
        return new NumberReceiverFacade(numberValidator, numberReceiverService);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }

}
