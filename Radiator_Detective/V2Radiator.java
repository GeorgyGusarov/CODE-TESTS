package Radiator_Detective;

import java.util.ArrayList;

public class V2Radiator {

    V2Radiator(ArrayList v2List) {  // конструктор
        for (int x = 0; x < 5; x++) {
            v2List.add(new SimUnit("V2радиатор"));
            System.out.println("V2 " + x);
        }
    }
}
