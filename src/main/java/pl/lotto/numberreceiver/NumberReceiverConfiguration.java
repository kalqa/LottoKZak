package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    NumberReceiverFacade buildModuleForClients() {
        NumberValidator numberValidator = new NumberValidator();
        NumberReceiverDateBase numberReceiverDateBase = new NumberReceiverDateBase();
        return new NumberReceiverFacade(numberValidator, numberReceiverDateBase);
    }

    NumberReceiverFacade buildModuleForTests() {
        return buildModuleForClients();
    }

}
