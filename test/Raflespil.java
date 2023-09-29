import java.util.Random;
public class Raflespil {

    // ... (eksisterende kode)

    public static void main(String[] args) {
        // ... (eksisterende kode)
        Random random = new Random();

        int[] sumCounts = new int[11]; // Indeks 2 til 12 for at repræsentere summen af to terninger fra 2 til 12
        int doublesCount = 0;

        for (int i = 0; i < 1000; i++) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;

            sumCounts[sum - 2]++; // Træk 2 fra summen for at matche indekserne i sumCounts

            if (dice1 == dice2) {
                doublesCount++;
            }
        }

        System.out.println("Resultater efter 1000 kast:");
        for (int i = 0; i < sumCounts.length; i++) {
            int sum = i + 2; // Tilbage til den faktiske sumværdi ved at tilføje 2
            double expectedProbability = getExpectedProbability(sum);
            System.out.println("Sum " + sum + ": Forekomster=" + sumCounts[i] + ", Forventet sandsynlighed=" + expectedProbability);
        }

        double expectedDoublesProbability = 1.0 / 6.0; // Forventet sandsynlighed for at slå ens terninger
        System.out.println("Antal kast med ens terninger: " + doublesCount + ", Forventet sandsynlighed=" + expectedDoublesProbability);

        // ... (eksisterende kode)

    }

    // Beregner den forventede sandsynlighed for en given sum af to terninger
    private static double getExpectedProbability(int sum) {
        if (sum < 2 || sum > 12) {
            return 0.0; // Ugyldig sum
        }

        int[] possibleOutcomes = {1, 2, 3, 4, 5, 6};
        int favorableOutcomes = 0;

        for (int outcome1 : possibleOutcomes) {
            for (int outcome2 : possibleOutcomes) {
                if (outcome1 + outcome2 == sum) {
                    favorableOutcomes++;
                }
            }
        }

        return (double) favorableOutcomes / 36.0; // Der er i alt 36 mulige udfald (6x6) med to terninger
    }
}
