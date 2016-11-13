package me.evilcorp.ImpQ;

/**
 * Created by ekzotech on 13.11.16.
 */
public class Program {
    public static void main(String[] args) {

        X x = new X();//создаём экземпляры классов
        Y y = new Y();
        Z z = new Z(); //а теперь мы создадим экземпляр обобщённого класса
        Q q = new Q(x, y, z); //не понимаю почему, но оно тут требует x y z

        System.out.println(q.allCalc(x, y, z)); //а потом требует их же указать здесь.

    }



}
