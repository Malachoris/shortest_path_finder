package com.assignment.nl22w.game.solution;

import com.assignment.nl22w.game.solution.interfaces.Reader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TextFileReader implements Reader {

    //Takes Resource and reads it as a String
    @Override
    public String read(Resource resource) {
        String fileText = "";
        try (Scanner input = new Scanner(resource.getInputStream()).useDelimiter("//A")) {
            while (input.hasNext()) {
                fileText += input.nextLine() + "\n";
            }
        } catch (Exception e) {
            return null;
        }
        return fileText;
    }
}
