package me.evilcorp.ImpQ;

/**
 * Created by ekzotech on 13.11.16.
 */
public class Q <X extends B, Y extends B, Z extends D> { //используя <> создаём обобщённый класс
    //но я не знаю, почему в самих класса X Y Z мы делаем иплимент, а тут экстенд
    //может мне кто-нибудь это объяснить?
    X x;
    Y y;
    Z z;

    public Q(X x, Y y, Z z) {//конструктор, ня! ^_^
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int allCalc(X x, Y y, Z z) {
        //объект.свойство; вот что мы вызываем
        //далее, поскольку нам было прикольно, то return в каждом случае возвращает своё значение
        //итого мы тут получаем sum = 4 (return z) + 2 (return y) + 1 (return x)
        int sum = z.calc() + y.calc2() + x.calc2();
        return sum;
    }

}
