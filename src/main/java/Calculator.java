public class Calculator {
    private final String delimiter = ",|\n";

    public int calculate(String input) throws Exception {
        // Sépare les nombres en utilisant les délimiteurs définis
        String[] numbers = input.split(delimiter);

        if (isEmpty(input)) {
            // Retourne 0 si l'entrée est vide (étape 1)
            return 0;
        }
        if (input.length() == 1) {
            // Retourne le nombre s'il y a un seul caractère (étape 1)
            return stringToInt(input);
        } else {
            // Calcule la somme des nombres (étape 2)
            return getSum(numbers);
        }
    }

    private int getSum(String[] numbers) throws Exception {
        // Vérifie les entrées dangereuses (étape 6)
        findDangerousInput(numbers);
        // Calcule la somme des valeurs valides (étape 2)
        return calculateValues(numbers);
    }

    private int calculateValues(String[] numbers) {
        int sum = 0;

        for (String current : numbers) {
            if (stringToInt(current) > 1000) {
                // Ignore les nombres supérieurs à 1000 (étape 8)
                continue;
            }
            sum += stringToInt(current);
        }
        return sum;
    }

    private void findDangerousInput(String[] numbers) throws Exception {
        for (String current : numbers) {
            if (stringToInt(current) < 0) {
                // Lance une exception pour les nombres négatifs (étape 6)
                throw new Exception("Negative input!");
            }
        }
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
