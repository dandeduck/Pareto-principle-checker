package github.dandeduck;

public interface ParetoChecker {
    default boolean check() {
        return checkForSpecificRatio(0.2, 0.8);
    }

    default boolean checkForSpecificRatio(double entryPercentage, double quantityPercentage) {
        return (double) quantityUntilPercentage(entryPercentage)/totalQuantity() >= quantityPercentage;
    }

    int quantityUntilPercentage(double entryPercentage);
    int totalQuantity();
}
