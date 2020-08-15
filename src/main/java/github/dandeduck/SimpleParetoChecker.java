package github.dandeduck;

import java.util.Arrays;
import java.util.List;

public class SimpleParetoChecker implements ParetoChecker {
    private final List<Entry> entries;

    public SimpleParetoChecker(Entry... entries) {
        this(Arrays.asList(entries));
    }

    public SimpleParetoChecker(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public int quantityUntilPercentage(double entryPercentage) {
        int targetIndex = (int) (Math.ceil(entryPercentage) * entries.size());
        int quantity = 0;

        for (int i = 0; i < targetIndex; i++)
            quantity += entries.get(i).quantity();

        return quantity;
    }

    @Override
    public int totalQuantity() {
        return entries.stream()
                .mapToInt(Entry::quantity)
                .sum();
    }
}
