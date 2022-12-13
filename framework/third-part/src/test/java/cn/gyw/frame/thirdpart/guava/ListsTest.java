package cn.gyw.frame.thirdpart.guava;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author
 * @desc
 * @createdTime 2022/6/8
 */
public class ListsTest {

    /**
     * 列表分区
     */
    @Test
    public void partition() {
        List<Integer> dataList =
                Stream.iterate(1, i -> i + 1).limit(3001).collect(Collectors.toList());

        List<List<Integer>> listGroup = Lists.partition(dataList, 1000);

        System.out.println(listGroup.size());
        listGroup.forEach(list -> System.out.println(list.get(list.size() - 1)));
    }

}
