import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        /*
         * Optional<Double> result = averageScores(7.0, 8.0, 4.0, 10.0);
         * if (result.isPresent()) {
         * System.out.println(result.get());
         * } else {
         * System.out.println("Nothing");
         * }
         * }
         */

        List<String> countries = new ArrayList<>();
        countries.add("United States");
        countries.add("Argentina");
        countries.add("Spain");
        countries.add("Italy");
        countries.add("Colombia");
        countries.add("Mexico");
        countries.add("Ecuador");
        countries.add("Peru");

        Optional<String> country = countries.stream()
                .filter(c -> c.startsWith("Arg")).findFirst();

        country.ifPresent(System.out::println);

    }

    public static Optional<Double> averageScores(Double... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (Double score : scores)
            sum += score;
        return Optional.of(sum / scores.length);

    }

}