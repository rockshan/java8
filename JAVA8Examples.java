public class Java8CodeExamples {
    /**
     * Depicts Comparator.naturalOrder
     * Works for null and empty string.
     */

    public static <T extends Comparable<T>> Optional<T> maxItem(List<T> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .max(Comparator.naturalOrder());
    }

    /**
     * More optimized version for integer, Less unboxing
     * Depicts Comparator.naturalOrder
     * Works for null and empty string.
     */

    public static <T extends Integer> OptionalInt maxInt(List<T> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .max();
    }
}
