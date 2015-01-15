import groovy.transform.Canonical
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class Transform {
    public class MyJavaClass{
        private final int x;
        private final int y;

        MyJavaClass(int x, int y) {
            this.x = x
            this.y = y
        }

        int getX() {
            return x
        }



        int getY() {
            return y
        }

        @Override
        public String toString() {
            return 'Transform$MyJavaClass('+ x + ", " + y + ')';
        }

        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false

            MyJavaClass that = (MyJavaClass) o

            if (x != that.x) return false
            if (y != that.y) return false

            return true
        }

        int hashCode() {
            int result
            result = x
            result = 31 * result + y
            return result
        }
    }//Start in line 7 -> 40 lines

    @Test
    public void commonJavaClass() throws Exception {
        MyJavaClass one = new MyJavaClass(2,3)
        MyJavaClass other = new MyJavaClass(2,3)

        assertThat(one.getX()).isEqualTo(2)
        assertThat(one.getY()).isEqualTo(3)
        assertThat(one.toString()).isEqualTo('Transform$MyJavaClass(2, 3)')
        assertThat(one).is(other)
    }

    @Canonical
    class MyGroovyClass{
        final int x;
        final int y;
    }

    @Test
    public void commonJavaClassInGroovy() throws Exception {
        MyGroovyClass one = new MyGroovyClass(2,3)
        MyGroovyClass other = new MyGroovyClass(2,3)

        assertThat(one.getX()).isEqualTo(2)
        assertThat(one.getY()).isEqualTo(3)
        assertThat(one.toString()).isEqualTo('Transform$MyGroovyClass(2, 3)')
        assertThat(one).is(other)
    }
}
