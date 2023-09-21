package com.example.resttask.controllers;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StringCompressControllerTest {


    @Test
    void compress() {
        List<String> input = new ArrayList<>();
        input.add("aaaaabcccc");
        input.add("aaa1aa1bcccc");
        input.add("aa$aaabccc$c");
        input.add("");
        List<String> output = new ArrayList<>();
        output.add("\"a\": 5 \"c\": 4 \"b\": 1");
        output.add("\"a\": 5 \"c\": 4 \"1\": 2 \"b\": 1");
        output.add("\"a\": 5 \"c\": 4 \"$\": 2 \"b\": 1");
        output.add("");
        List<String> out = new ArrayList<>();
        for(String str:input){
            out.add(StringCompressController.compress(str));
        }
        assertEquals(output, out);
    }
}