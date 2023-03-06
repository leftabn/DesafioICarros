package br.com.icarros.testes.angrymarvinbirds;

import java.util.ArrayList;
import java.util.List;

public class AngryMarvinBirds {
    static List<String> generateCombinations() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, 3); i++) {
            String response = String.format("%3s", Integer.toBinaryString(i))
                    .replaceAll("[ -0]", "-")
                    .replaceAll("1", "*");
            results.add(response);
        }
        return results;
    }

    static int countMarvinStars(List<String> marvinResults) {
        return marvinResults.stream().flatMapToInt(s -> s.chars().map(c -> c == '*' ? 1: 0)).sum();
    }

    public static void main(String[] args) {
        List<String> combinations = generateCombinations();
        System.out.println(countMarvinStars(combinations));
    }
}
