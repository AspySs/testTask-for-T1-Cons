package com.example.resttask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class StringCompressController {

    @GetMapping("/compressor")
    public String compressor(@RequestParam("str") String string, Model model) {
        model.addAttribute("input", string);

        model.addAttribute("output", compress(string));

        return "compressor";
    }



    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mp = new HashMap<>();
        for(Character ch:str.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch,0)+1);
        }
        Set<Map.Entry<Character,Integer>> entries = mp.entrySet();
        List<Map.Entry<Character,Integer>> lst = entries.stream().sorted(Comparator.comparingInt((Map.Entry::getValue))).toList();
        for(int i =lst.size()-1; i>=0;i--){
            sb.append('"').append(lst.get(i).getKey()).append("\": ").append(lst.get(i).getValue());
            if(i!=0){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
