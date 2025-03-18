package labs.lab10;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongsStats {

    public static long problem1_countArtists(Stream<Song> songs) {
        return songs.map(Song::getArtist).distinct().count();
    }

    public static String problem2_getTracksByArtist(Stream<Song> songs, String artist) {
        return songs.filter(song -> song.getArtist().equals(artist))
                .map(Song::getTrack).sorted().collect(Collectors.joining(", "));
    }

    public static Optional<Song> problem3_getFastestSong(Stream<Song> songs) {
        return songs.max((s1, s2) -> Double.compare(s1.getTempo(), s2.getTempo()));
    }

    public static Optional<Song> problem3_getSlowestSong(Stream<Song> songs) {
        return songs.min((s1, s2) -> Double.compare(s1.getTempo(), s2.getTempo()));
    }

    public static List<Key> problem4_getMostPopularKeyInYearRange(Stream<Song> songs,
                                                                  Year minYear, Year maxYear) {
        Map<Key, Long> keyCounts = songs
                .filter(song -> {
                    Year year = song.getYear();
                    return (year.compareTo(minYear) >= 0 && year.compareTo(maxYear) <= 0);
                })
                .collect(Collectors.groupingBy(Song::getKey, Collectors.counting()));

        long maxCount = keyCounts.values().stream()
                .max(Long::compareTo)
                .orElse(0L);

        return keyCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> problem5_countSongsByGenre(Stream<Song> songs) {
        return songs
                .map(Song::getGenre)
                .filter(Objects::nonNull)
                .flatMap(genre -> Arrays.stream(genre.split("\\|")))
                .map(String::trim)
                .collect(Collectors.groupingBy(genre -> genre, TreeMap::new, Collectors.counting()));
    }

    public static long problem6_countDuplicateSongs(Stream<Song> songs) {
        return songs
                .collect(Collectors.groupingBy(Song::getTrack, Collectors.counting()))
                .values().stream()
                .filter(count -> count > 1)
                .mapToLong(count -> count - 1)
                .sum();
    }

    public static String problem7_getMostPopularArtist(Stream<Song> songs) {
        Optional<Map.Entry<String, Double>> mostPopularArtist = songs
                .collect(Collectors.groupingBy(
                        Song::getArtist,
                        Collectors.averagingInt(Song::getPopularity)
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue));

        return mostPopularArtist.map(Map.Entry::getKey).orElse("");
    }

    public static double problem8_getAverageDifferenceBetweenEnergyAndDanceability(Stream<Song> songs) {
        return songs
                .mapToDouble(song -> song.getEnergy() - song.getDanceability())
                .average()
                .orElse(0);
    }

    public static Song problem9_getFirstTrackContainingString(Stream<Song> songs,
                                                              String str) {
        return songs
                .sorted(Comparator.comparing(song -> song.getTrack()))
                .filter(song -> song.getTrack().toLowerCase().contains(str.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public static List<String> problem10_getGenres(Stream<Song> songs) {
        return songs
                .map(Song::getGenre)
                .flatMap(genre -> Arrays.stream(genre.split("\\|")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
