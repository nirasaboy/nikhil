package in.ashokit.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MYApplicationrunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MYApplicationrunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Starting ApplicationRunner");

        try {
            // Your logic here
        } catch (Exception e) {
            logger.error("Exception occurred while running ApplicationRunner", e);
        }

        logger.info("Finished ApplicationRunner");
    }
}
