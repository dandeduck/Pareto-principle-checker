package github.dandeduck;

import java.util.ArrayList;
import java.util.List;

public class SimpleParetoCheckerBuilder {
    private final List<Entry> entries;

    public SimpleParetoCheckerBuilder() {
        this.entries = new ArrayList<>();
    }

    public SimpleParetoCheckerBuilder add(Entry entry) {
        entries.add(entry);

        return this;
    }

    public SimpleParetoChecker build() {
        return new SimpleParetoChecker(entries);
    }
}
