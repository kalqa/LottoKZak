package pl.lotto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.lotto.numberreceiver.NumberReceiverRepository;
import pl.lotto.numberreceiver.NumberUserCoupon;

//@SpringBootApplication
//public class LottoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(LottoApplication.class, args);
//	}
//
//}


@SpringBootApplication
public class LottoApplication
        implements CommandLineRunner {

    @Autowired
    NumberReceiverRepository numberReceiverRepository;

    private static Logger LOG = LoggerFactory
            .getLogger(LottoApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(LottoApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }

        numberReceiverRepository.save(new NumberUserCoupon(UUID.randomUUID(), List.of(1, 2, 3, 4, 5, 6), LocalDateTime.now()));
    }
}
