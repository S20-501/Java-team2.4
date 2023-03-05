import java.util.Scanner;
import java.util.Random;

//"Если метод изменяет объект, для которого он вызывается, то такой метод называется модифицирующим"

//"А если вызываемый метод оставляет объект без изменения, то он называется методом доступа"




//Scanner


//public int nextInt(int radix) {
//        // Check cached result
//        if ((typeCache != null) && (typeCache instanceof Integer)
//        && this.radix == radix) {
//        int val = ((Integer)typeCache).intValue();
//        useTypeCache();
//        return val;
//        }
//        setRadix(radix);
//        clearCaches();
//        // Search for next int
//        try {
//        String s = next(integerPattern());
//        if (matcher.group(SIMPLE_GROUP_INDEX) == null)
//        s = processIntegerToken(s);
//        return Integer.parseInt(s, radix);
//        } catch (NumberFormatException nfe) {
//        position = matcher.start(); // don't skip bad token
//        throw new InputMismatchException(nfe.getMessage());
//        }
//        }


//В классе Scanner это модифицирующий метод, тк он после возврата искомого значения вызывает методы, изменяющие например поле private int radix
//то есть он изменяет объект, для которого вызывается






//Random

//public int nextInt() {
//        return next(32);
//        }
//
//
//public int nextInt(int bound) {
//        if (bound <= 0)
//        throw new IllegalArgumentException(BAD_BOUND);
//        int r = next(31);
//        int m = bound - 1;
//        if ((bound & m) == 0)  // i.e., bound is a power of 2
//        r = (int)((bound * (long)r) >> 31);
//        else { // reject over-represented candidates
//        for (int u = r;
//        u - (r = u % bound) + m < 0;
//        u = next(31))
//        ;
//        }
//        return r;
//        }
//
//
//public int nextInt() {
//        return this.generator.nextInt();
//        }


//protected int next(int bits) {
//        long oldseed, nextseed;
//        AtomicLong seed = this.seed;
//        do {
//        oldseed = seed.get();
//        nextseed = (oldseed * multiplier + addend) & mask;
//        } while (!seed.compareAndSet(oldseed, nextseed));
//        return (int)(nextseed >>> (48 - bits));
//        }


//В классе Random nextInt это метод доступа, тк он генерирует int в методе next() не изменяя никаких полей