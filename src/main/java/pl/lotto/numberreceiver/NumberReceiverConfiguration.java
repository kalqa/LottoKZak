package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        return new NumberReceiverFacade(numberValidator);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }

}
