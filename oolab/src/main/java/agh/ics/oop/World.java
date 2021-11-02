package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class World{
    public static void run(List<Direction> args){
        for (Direction arg : args){
            String mess = switch (arg){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
            };

            out.println(mess);
        }
    }

    public static List<Direction> translate(String[] input){
        List<Direction> output = new ArrayList<>();

        for (String arg : input){
            String mess = switch(arg){
                case "f" -> "FORWARD";
                case "b" -> "BACKWARD";
                case "r" -> "RIGHT";
                case "l" -> "LEFT";
                default -> "pass";
            };

            if (! mess.equals("pass")) {
                output.add(Direction.valueOf(mess));
            }
        }

        return output;
    }

    public static void main(String[] args){
        out.println("Start");

        String[] sample = new String[]{"f", "f", "mazik", "r", "f", "adsa", "ad", "l", "b"};
        OptionsParser sampleInput = new OptionsParser(sample);
        List<MoveDirection> directions = sampleInput.parse();

        Animal sampleAnimal = new Animal();
        for (MoveDirection move : directions) {
            sampleAnimal.move(move);
        }
        out.println(sampleAnimal);
        out.println("Stop");
    }
}