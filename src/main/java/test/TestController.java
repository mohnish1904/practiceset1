package test;

import lombok.val;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TestController{

    public static void main(String[] args) {
        List<String> strings = List.of("abcd", "efgh");

        List<String> collect = strings.stream()
                .map(str -> {
                    StringBuilder sb = new StringBuilder(str);
                    return sb.reverse().toString();
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }



}