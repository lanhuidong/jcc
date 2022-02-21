package com.nexusy.jcc.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lanhuidong
 * @since 2022-02-21
 */
public class StdRestErrorTest {

    @Test
    void test() {
        Set<Integer> codes = Arrays.stream(StdRestError.values()).map(StdRestError::getCode).collect(Collectors.toSet());
        Assertions.assertEquals(StdRestError.values().length, codes.size(), "StdRestError中有code重复，请认真核对!");
    }

    @Test
    void testToString(){
        System.out.println(StdRestError.NOT_LOGIN);
    }

}
