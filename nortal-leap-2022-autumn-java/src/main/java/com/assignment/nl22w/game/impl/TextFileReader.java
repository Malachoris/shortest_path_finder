package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.interfaces.Reader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TextFileReader implements Reader {

    //Takes Resource and reads it as a String
    @Override
    public String read(Resource resource) {
        // you can add things to an empty String ("") but not null value String.
        String fileText = "";
        try (Scanner input = new Scanner(resource.getInputStream())) {
            while (input.hasNext()) {
                fileText += input.nextLine() + "\n";
            }
        } catch (Exception e) {
            return null;
        }
        return fileText;
    }
}
