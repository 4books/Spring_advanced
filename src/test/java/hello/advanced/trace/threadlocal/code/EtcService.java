package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EtcService {

    public void printName(String name) {
        log.info("name={}", name);
        sleep(1000);
        name += " hello";
        log.info("name={}", name);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
