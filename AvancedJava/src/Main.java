import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        // Streams / Lambda

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Cuidad de Mexico");
        cities.add("Lima");

/* 
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
 */

 /* 
        for (String city : cities){
            System.out.println(city);
        }
 */ 

/*         
        //Lambda
        cities.stream().forEach(city -> System.out.println(city));

        //Reference to Method
        cities.stream().forEach(Main::printCity);

        // More simple
        cities.stream().forEach(System.out::println);
 */

/*         
        //Lambda
        cities.forEach(city -> System.out.println(city));

        //Reference to Method
        cities.forEach(Main::printCity);

        // More simple
        cities.forEach(System.out::println); 
*/

        // Simple exemple of Parallel - Pipeline
        // cities.stream().parallel().forEach(System.out::println);

/*      cities.stream().filter(city -> city.startsWith("B"))
                .forEach(System.out::println); */

/*         cities.stream().filter(Main::filterCity)
                .forEach(System.out::println);
 */

/*         cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .forEach(System.out::println);
 */

        List<String> filteredCities = cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .collect(Collectors.toList());

        System.out.println(filteredCities);
        
    }

        public static boolean filterCity(String city){
            return city.startsWith("B");
        }

        public static void printCity(String city){
            System.out.println(city);
    }

    
}