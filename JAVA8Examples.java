public class Java8CodeExamples {
    ///////////////////REDUCE EXAMPLES////////////////////////
    
     /**
     * sum of all the elements
     */
    public static int findSum(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElse(Collections.emptyList())
                .stream()
                .reduce(0, (a, b) -> a +b);
    }


    /**
     * sum of all the elements without initial value
     */
    public static Optional<Integer> findSumWithoutInitialValue(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElse(Collections.emptyList())
                .stream()
                .reduce((a, b) -> a +b);
    }
    ///////////////////REDUCE EXAMPLES////////////////////////
    
    
    
    /**
     * Generate pair from two list
     */
    public static List<int []> generatePair(List<Integer> l1, List<Integer> l2) {

        return l1.stream()
                .flatMap(
                        i -> l2.stream()
                                .map(j -> new int[]{i,j})
                ).collect(Collectors.toList());
    }
    
    
    /**
     * Check if at least one even
     */

    public static boolean atLeastOneEven(List<Integer> intList) {
        return Optional.ofNullable(intList)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .anyMatch(i -> i %2 == 0);
    }
    
     /**
     * Check if all even in list
     */

    public static boolean allEven(List<Integer> intList) {
        return Optional.ofNullable(intList)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .allMatch(i -> i %2 == 0);
    }
    
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
     * Get character string for each word
     * Works on Null and empty list
     */

    public static List<String> getCharAsStringList(List<String> words) {
         return Optional.ofNullable(words)
                .orElse(Collections.emptyList())
                .stream()
                .map(w -> w.split(""))
                .flatMap(arr -> Arrays.stream(arr))
                .collect(Collectors.toList());
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
    
    
    /**
     * Filtering unique elements
     * This works on Generic, null and empty list
     */

    public static <T> List<T> getUniqueItems(List<T> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    /**
     * find any even element
     */
    public static Optional<Integer> findAnyEven(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(i -> i%2 == 0)
                .findAny();
    }

    /**
     * find first even element
     */
    public static Optional<Integer> findFirstEven(List<Integer> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(i -> i%2 == 0)
                .findFirst();
    }
}
