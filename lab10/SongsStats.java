package labs.lab10;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class SongsStats {
    /**
     * Counts how many distinct artists are represented in the given Stream of
     Songs
     *
     * @param songs input stream of Songs
     *
     * @return the number of distinct artists are represented in the given
    Stream of Songs
     */
    public static long problem1_countArtists(Stream<Song> songs) {

        return songs.map(Song::getArtist).distinct().count(); // FIX ME
    }
    /**
     * Given a Stream of Songs and an artist, returns a comma-separated string of
     all
     * the song tracks by that artist, sorted in ascending lexicographic order by
     track
     *
     * @param songs input stream of Songs
     *
     * @return a comma-separated string of all the song tracks by that artist,
    sorted
     * in ascending lexicographic order by track
     */
    public static String problem2_getTracksByArtist(Stream<Song> songs, String
            artist) {
        return songs.filter(song -> song.getArtist().equals(artist))
                .map(Song::getTrack).sorted().collect(Collectors.joining(", ")); // FIX ME
    }
    /**
     * Returns the song with the fastest tempo in the stream. If more than one
     song
     * has the fastest tempo, just return any one of them.
     *
     * @param songs input stream of Songs
     *
     * @return the song with the fastest tempo in the stream. If more than one
    song
     * has the fastest tempo, just return any one of them.
     */
    public static Optional<Song> problem3_getFastestSong(Stream<Song> songs) {
        return Optional.empty(); // FIX ME
    }
    /**
     * Returns the song with the slowest tempo in the stream. If more than one
     song
     * has the slowest tempo, just return any one of them.
     *
     * @param songs input stream of Songs
     *
     * @return the song with the slowest tempo in the stream. If more than one
    song
     * has the slowest tempo, just return any one of them.
     */
    public static Optional<Song> problem3_getSlowestSong(Stream<Song> songs) {
        return Optional.empty(); // FIX ME
    }
    /**
     * Given a Stream of Songs, a min year, and a max year, return a list
     containing the most popular
     * key of songs within that year range (min and max inclusive). If two or
     more keys are equally
     * popular, the list will have multiple elements (all the equally popular
     keys, in any order).
     * Otherwise, the list will have only one element (assuming there is at least
     one song in the
     * stream).
     *
     * @param songs stream of Songs
     * @param minYear year range lower bound (inclusive)
     * @param maxYear year range upper bound (inclusive)
     *
     * @return a list containing the most popular key(s)
     */
    public static List<Key> problem4_getMostPopularKeyInYearRange(Stream<Song>
                                                                          songs,
                                                                  Year minYear, Year maxYear) {
        return null; // FIX ME
    }
    /**
     * Counts the number of Songs in each genre.
     * Grabs all Songs from the stream and groups them by genre.
     * Returns a Map<String, Long> that maps genres to the number of Songs in
     that genre.
     *
     * This map should be sorted in ascending order of genre.
     *
     * If the stream is empty, returns an empty map.
     *
     * @param songs input stream of Songs
     *
     * @return a Map<String, Long> that maps genres to the number of Songs in
    that genre
     */
    public static Map<String, Long> problem5_countSongsByGenre(Stream<Song>
                                                                       songs) {
        return null; // FIX ME
    }
    /**
     * Given a Stream of Songs, return the number of Songs whose title (track) is
     * a duplicate of another Song (case-sensitive)
     *
     * @param songs input stream of Songs
     *
     * @return the number of duplicate Songs
     */
    public static long problem6_countDuplicateSongs(Stream<Song> songs) {
        return -1L; // FIX ME
    }
    /**
     * Given a Stream of Songs, return the name of the artist with the highest
     average popularity
     * in the stream, based on the average popularity of that artist's songs. If
     more than one
     * artist has the highest average popularity, return any one of them.
     *
     * If the stream is empty, return the empty String.
     *
     * @param songs stream of Songs
     *
     * @return the name of the artist with the highest average popularity in the
    stream, based
     * on the average popularity of that artist's songs
     */
    public static String problem7_getMostPopularArtist(Stream<Song> songs) {
        return ""; // FIX ME
    }
    /**
     * Given a stream of Songs, returns the average difference between energy and
     danceability
     * (energy minus danceability) for songs in the stream.
     *
     * For an empty stream, just return 0.
     *
     * @param songs stream of Songs
     *
     * @return the average difference between energy and danceability (energy
    minus
     * danceability) for songs in the stream.
     */
    public static double
    problem8_getAverageDifferenceBetweenEnergyAndDanceability(Stream<Song> songs) {
        return -1; // FIX ME
    }
    /**
     * Returns the first Song whose track contains the given string (ignoring
     case),
     * or else null if none found. "First" here means the first track
     encountered, when
     * considering tracks sorted in ascending lexicographic order. So if tracks
     "A", "B", and "C"
     * all contain the string, track "A" will be found first.
     *
     * @param songs input stream of Songs
     * @param str string to search for in tracks
     *
     * @return first Song whose description contains the given string (ignoring
    case),
     * or else null if none found
     */
    public static Song problem9_getFirstTrackContainingString(Stream<Song> songs,
                                                              String str) {
        return null; // FIX ME
    }
    /**
     * Gets a list of all genres in a stream of Songs, sorted in ascending
     lexicographic order.
     *
     * @param songs input stream of Songs
     *
     * @return list of all genres in a stream of Songs, sorted in ascending
    lexicographic order
     */
    public static List<String> problem10_getGenres(Stream<Song> songs) {
        return null; // FIX ME
    }
}
