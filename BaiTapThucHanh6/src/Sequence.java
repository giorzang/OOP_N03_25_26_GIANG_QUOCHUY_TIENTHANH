public class Sequence {
    private Object[] objects;
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next] = x;
            next++;
        }
    }

    private class SSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == next;
        }

        public Object current() {
            if (i < next) return objects[i];
            return null;
        }

        public void next() {
            if (i < next) i++;
        }
    }

    public Selector getSelector() {
        return new SSelector();
    }
}
