import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulationMots {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("Java", "Python", "Scala", "JavaScript", "C#", "Ruby", "Swift");

        // Filtrer les mots qui contiennent la lettre "a"
        List<String> motsAvecA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant la lettre 'a': " + motsAvecA);

        // Filtrer les mots qui ont une longueur supérieure à 3 et les transformer en leur inverse
        List<String> motsInverseLongueurSup3 = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots inversés de longueur supérieure à 3: " + motsInverseLongueurSup3);

        // Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de caractères
        List<Character> caracteresAvecE = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant la lettre 'e': " + caracteresAvecE);

        // Transformer chaque chaîne en sa version en majuscules
        List<String> motsEnMajuscules = mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules: " + motsEnMajuscules);

        // Convertir chaque chaîne en sa longueur
        List<Integer> longueursMots = mots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueurs des mots: " + longueursMots);

        // Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères
        List<Character> caracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Liste de caractères: " + caracteres);

        // Transformer chaque nom en une chaîne de la forme "Nom - Index"
        List<String> nomsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .collect(Collectors.toList());
        System.out.println("Noms avec index: " + nomsAvecIndex);
    }
}