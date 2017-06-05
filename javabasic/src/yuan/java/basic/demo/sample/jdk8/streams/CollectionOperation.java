package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.*;

/**
 * Created by yuanxin on 17/6/1.
 */
public class CollectionOperation
{

    private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 1000, Type.MEAT),
        new Dish("beef", false, 700, Type.MEAT),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OTHER),
        new Dish("rice", true, 350, Type.OTHER),
        new Dish("season fruit", true, 120, Type.OTHER),
        new Dish("pizza", true, 500, Type.OTHER),
        new Dish("prawns", false, 300, Type.FISH),
        new Dish("salmon", false, 450, Type.FISH)
    );

    private void testSum(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream().reduce(1,Integer ::sum);
    }

    private static void testCollection(){
        List<String> taCodeList =  new ArrayList<>();
        taCodeList.add("0005");
        DisSubCompanyModel subCompanyModel = new DisSubCompanyModel();
        subCompanyModel.setSubCompanyNo("10000");
        subCompanyModel.setTaCodeList(taCodeList);

        DisSubCompanyModel subCompanyModelTwo = new DisSubCompanyModel();
        subCompanyModelTwo.setSubCompanyNo("10000");
        subCompanyModelTwo.setTaCodeList(taCodeList);

        List<DisSubCompanyModel> list = new ArrayList<>();
        list.add(subCompanyModel);
        list.add(subCompanyModelTwo);

        List<String> inlist = new ArrayList<>();
        Set<String> stirngs =  list.stream().map(disSubCompanyModel -> {return new HashSet<>(disSubCompanyModel.getTaCodeList());})
                .reduce(new HashSet<String>(),(set1,set2)->{
                    set1.addAll(set2);
                    return set2;
        });
        stirngs.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCollection();
    }

}
