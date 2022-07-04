package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.EtcService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class EtcServiceTest {

    private EtcService service = new EtcService();

    @Test
    void printTest(){
        log.info("main start");
        Runnable userA = () -> {
            service.printName("userA");
        };
        Runnable userB = () -> {
            service.printName("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);//지역 변수는 문제 생기지 않음. 쓰레드마다 메모리가 다름
        threadB.start();

        sleep(3000); //메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
