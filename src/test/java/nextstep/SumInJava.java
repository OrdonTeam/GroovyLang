package nextstep;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.fest.assertions.api.Assertions.assertThat;

public class SumInJava {
    public class Bucket{
        private final int count;
        public Bucket(int count) {
            this.count = count;
        }
        public int getCount() {
            return count;
        }
    }


    @Test
    public void testName() throws Exception {
        List<Bucket> buckets = new ArrayList<>();
        buckets.add(new Bucket(5));
        buckets.add(new Bucket(2));

        Optional<Integer> sum =
                buckets.stream().
                        map(Bucket::getCount).
                        reduce((l, r) -> (l + r));
        assertThat(sum.get()).isEqualTo(7);
    }
}
