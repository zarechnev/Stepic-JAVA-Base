package P61_Generics;

public class Main {
    public static void main(String[] args) {
        //Pair<Integer, String> pair = Pair.of(1, "hello");
        Pair<Integer, String> pair = Pair.of(null, null);

        //Pair<Integer, String> pair2 = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(null, 1);
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}

class Pair <T,U> {
    T t;
    U u;

    static public <T,U> Pair of(T t, U u) {
        return new Pair(t, u);
    }

    private Pair(T first, U second){
        this.t = first;
        this.u = second;
    }

    public T getFirst() {
        return this.t;
    }

    public U getSecond() {
        return this.u;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        Pair inPair = (Pair) obj;

        if (this.t != null && !this.t.equals(inPair.t) || inPair.t != null && !inPair.t.equals(this.t))
            return false;

        if (this.u != null && !this.u.equals(inPair.u) || inPair.u != null && !inPair.u.equals(this.u))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int first = (t == null ? 431 : this.t.hashCode());
        int second = (u == null ? -1230 : this.u.hashCode());
        return first / 2 + second / 2;
    }
}