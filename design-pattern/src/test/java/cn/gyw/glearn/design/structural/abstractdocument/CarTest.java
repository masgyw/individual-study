package cn.gyw.glearn.design.structural.abstractdocument;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date 2023/10/19
 */
public class CarTest {

    @Test
    public void test() {
        Map<String, Object> wheelProperties = new HashMap<>();
        wheelProperties.put(Property.TYPE.toString(), "wheel");
        wheelProperties.put(Property.MODEL.toString(), "15C");
        wheelProperties.put(Property.PRICE.toString(), 100L);

        Map<String, Object> doorProperties = new HashMap<>();
        doorProperties.put(Property.TYPE.toString(), "door");
        doorProperties.put(Property.MODEL.toString(), "Lambo");
        doorProperties.put(Property.PRICE.toString(), 300L);

        Map<String, Object> carProperties = new HashMap<>();
        carProperties.put(Property.MODEL.toString(), "300SL");
        carProperties.put(Property.PRICE.toString(), 10000L);
        List<Map<String, Object>> list = new ArrayList<>(2);
        list.add(wheelProperties);
        list.add(doorProperties);
        carProperties.put(Property.PARTS.toString(), list);

        Car car = new Car(carProperties);

        System.out.println("here is our car");
        System.out.println("-> model :" + car.getModel().orElseThrow(RuntimeException::new));
        System.out.println("-> price :" + car.getPrice().orElseThrow(RuntimeException::new));
        car.getParts().forEach(t -> {
            System.out.println("-> type :" + t.getType().orElse(null));
            System.out.println("-> model :" + t.getModel().orElse(null));
            System.out.println("-> price :" + t.getPrice().orElse(null));
        });
    }
}