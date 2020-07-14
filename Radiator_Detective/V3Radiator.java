package Radiator_Detective;

import java.util.ArrayList;

public class V3Radiator extends V2Radiator {

    V3Radiator(ArrayList v3List) {  // конструктор
        super(v3List);
        for (int g = 0; g < 10; g++) {
            v3List.add(new SimUnit("V3радиатор"));
            System.out.println("V3 " + g);
        }

    }
}
