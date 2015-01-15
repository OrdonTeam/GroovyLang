import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class Collections {

    @Test
    public void collectionsInJava() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertThat(list).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void collectionInGroovy() throws Exception {
        ArrayList<Integer> list = [1, 2, 3, 4, 5]

        assertThat(list).containsExactly(1, 2, 3, 4, 5)
    }

    @Test
    public void multiplyArrayInJava() throws Exception {
        List<Integer> list = [1, 2, 3, 4, 5];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            result.add(list.get(i) * 2);

        assertThat(result).containsExactly(2, 4, 6, 8, 10);
    }

    @Test
    public void multiplyArrayInJavaForEach() throws Exception {
        List<Integer> list = [1, 2, 3, 4, 5];

        List<Integer> result = new ArrayList<>();
        for (Integer it : list)
            result.add(it * 2);

        assertThat(result).containsExactly(2, 4, 6, 8, 10);
    }

    @Test
    public void multiplyArrayInGroovy() throws Exception {
        ArrayList<Integer> list = [1, 2, 3, 4, 5]

        List<Integer> result = list.collect {
            it * 2
        }

        assertThat(result).containsExactly(2, 4, 6, 8, 10)
    }

    @Test
    public void forIInJava() throws Exception {
        int NUMBER_OF_TIMES = 5;

        ArrayList<MyClass> list = new ArrayList<>();
        for(int i=0;i< NUMBER_OF_TIMES;i++)
            list.add(new MyClass());

        assertThat(list.size()).isEqualTo(NUMBER_OF_TIMES);
    }

    @Test
    public void forIInGroovy() throws Exception {
        int NUMBER_OF_TIMES = 5

        ArrayList<MyClass> list = []
        NUMBER_OF_TIMES.times{
            list.add(new MyClass())
        }

        assertThat(list.size()).isEqualTo(NUMBER_OF_TIMES)
    }
}
