package github.dandeduck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleParetoChecker implements ParetoChecker {
    private final List<Integer> entries;

    public SimpleParetoChecker(Entry... entries) {
        this(Arrays.asList(entries));
    }

    public SimpleParetoChecker(List<Entry> entries) {
        this.entries = entries.stream().mapToInt(Entry::quantity).sorted().boxed().collect(Collectors.toList());
    }

    @Override
    public int quantityUntilPercentage(double entryPercentage) {
        int targetIndex = (int) (Math.ceil(entryPercentage) * entries.size());
        int quantity = 0;

        for (int i = 0; i < targetIndex; i++)
            quantity += entries.get(i);

        return quantity;
    }

    @Override
    public int totalQuantity() {
        return entries.stream().mapToInt(value -> value).sum();
    }
}
