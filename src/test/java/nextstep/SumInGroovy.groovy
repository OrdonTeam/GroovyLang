package nextstep

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class SumInGroovy {
    @Canonical
    class Bucket{
        int count
    }

    @Test
    public void sumCount() throws Exception {
        List<Bucket> buckets = [new Bucket(5),new Bucket(2)]
        int sum = buckets.sum {
            return it.count
        }
        assertThat(sum).isEqualTo(7)
    }
}
