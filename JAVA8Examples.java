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
    
    
    /**
     * Accepts list for words and create a hashmap of string and its length.
     * This should work for empty and null string
     *
     */
    public static Map<String, Integer> getStringLengthPair(List<String> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                //.collect(Collectors.toMap(w -> w, w -> w.length())) -> this is also correct
                .collect(Collectors.toMap(String::toString, String::length));
    }
    
    /**
     * Sort string based on length
     */
    public static List<String> sortStringByLength(List<String> list) {
        Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .sort(Comparator.comparing(String::length));

        return list;
    }
}
