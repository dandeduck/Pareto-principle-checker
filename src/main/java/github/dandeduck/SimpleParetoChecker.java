package github.dandeduck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleParetoChecker implements ParetoChecker {
    private final List<Integer> quantities;

    public SimpleParetoChecker(Entry... quantities) {
        this(Arrays.asList(quantities));
    }

    public SimpleParetoChecker(List<Entry> entries) {
        this.quantities = extractQuantities(entries);
        Collections.reverse(quantities);
    }

    @Override
    public int quantityUntilPercentage(double entryPercentage) {
        int targetIndex = (int) Math.ceil(entryPercentage * quantities.size());
        int quantity = 0;

        for (int i = 0; i < targetIndex; i++)
            quantity += quantities.get(i);

        return quantity;
    }

    @Override
    public int totalQuantity() {
        return quantities.stream().mapToInt(value -> value).sum();
    }

    private List<Integer> extractQuantities(List<Entry> entries) {
        return entries.stream().mapToInt(Entry::quantity).sorted().boxed().collect(Collectors.toList());
    }
}
