package TestWork;

// Позволяет возвращать функции initArrays сразу 3 значения
final class Counter {
    private final int x;
    private final int s;
    private final int m;

    public Counter(int x, int s, int m) {
        this.x = x;
        this.s = s;
        this.m = m;
    }

    public int getX() {
        return x;
    }

    public int getS() {
        return s;
    }

    public int getM() {
        return m;
    }
}

