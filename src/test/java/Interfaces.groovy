import groovy.json.JsonSlurper
import org.junit.Test

import java.util.concurrent.atomic.AtomicBoolean

import static org.fest.assertions.api.Assertions.assertThat

class Interfaces {
    @Test
    public void runThreadInJava() throws Exception {
        AtomicBoolean result = new AtomicBoolean(false);

        new Thread(new Runnable() {
            @Override
            void run() {
                result.set(true);
            }
        }).start();

        Thread.sleep(1000);
        assertThat(result.get()).isTrue();
    }

    @Test
    public void runThreadInGroovy() throws Exception {
        AtomicBoolean result = new AtomicBoolean(false)

        new Thread({
            result.set(true)
        }).start()

        Thread.sleep(1000)
        assertThat(result.get()).isTrue()
    }
}
