package pl.lotto.numbergenerator;

class NumberGeneratorConfiguration {

    private final NumberGeneratorRepository numberGeneratorRepository;

    NumberGeneratorConfiguration(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
    }

    NumberGeneratorFacade buildModuleForClients() {
        return new NumberGeneratorFacade(numberGeneratorRepository);
    }

    NumberGeneratorFacade buildModuleForTests() {
        return buildModuleForClients();
    }
}
