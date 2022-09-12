package com.nexusy.jcc.misc;

/**
 * @author lanhuidong
 * @since 2022-08-05
 */
public final class Tuples {

    private Tuples() {
        throw new AssertionError();
    }

    public static <T1> Tuple1<T1> of(T1 f1) {
        return new Tuple1<>(f1);
    }

    public static <T1, T2> Tuple2<T1, T2> of(T1 f1, T2 f2) {
        return new Tuple2<>(f1, f2);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 f1, T2 f2, T3 f3) {
        return new Tuple3<>(f1, f2, f3);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 f1, T2 f2, T3 f3, T4 f4) {
        return new Tuple4<>(f1, f2, f3, f4);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 f1, T2 f2, T3 f3, T4 f4, T5 f5) {
        return new Tuple5<>(f1, f2, f3, f4, f5);
    }

    static class Tuple1<T1> {
        public final T1 f1;

        public Tuple1(T1 f1) {
            this.f1 = f1;
        }
    }

    static class Tuple2<T1, T2> {
        public final T1 f1;
        public final T2 f2;

        public Tuple2(T1 f1, T2 f2) {
            this.f1 = f1;
            this.f2 = f2;
        }
    }

    static class Tuple3<T1, T2, T3> {
        public final T1 f1;
        public final T2 f2;
        public final T3 f3;

        public Tuple3(T1 f1, T2 f2, T3 f3) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }
    }

    static class Tuple4<T1, T2, T3, T4> {
        public final T1 f1;
        public final T2 f2;
        public final T3 f3;
        public final T4 f4;

        public Tuple4(T1 f1, T2 f2, T3 f3, T4 f4) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
            this.f4 = f4;
        }
    }

    static class Tuple5<T1, T2, T3, T4, T5> {
        public final T1 f1;
        public final T2 f2;
        public final T3 f3;
        public final T4 f4;
        public final T5 f5;

        public Tuple5(T1 f1, T2 f2, T3 f3, T4 f4, T5 f5) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
            this.f4 = f4;
            this.f5 = f5;
        }
    }

}
