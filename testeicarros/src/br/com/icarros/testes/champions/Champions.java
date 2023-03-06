package br.com.icarros.testes.champions;

import java.util.stream.IntStream;

public class Champions {
    static int findChampion(int[] wins, int[] ties) {
        int[] points = new int[wins.length];

        for (int i = 0; i < wins.length; i++) {
            points[i] = wins[i]*3 + ties[i];
        }

        return IntStream.range(0, points.length)
                .reduce((i, j) -> points[i] > points[j] ? i : j).getAsInt();
     }

    public static void main(String[] args) {
        int[] wins = {1,0,3};
        int[] ties = {2,2,0};
        System.out.println(findChampion(wins, ties));
    }
}