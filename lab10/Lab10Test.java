package labs.lab10;
import static org.junit.Assert.*;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import labs.lab10.*;
import org.junit.Before;
import org.junit.Test;
public class Lab10Test {
    private final double EPSILON = 1e-3;
    List<Song> songList1;
    List<Song> songList2;
    List<Song> songList3;
    List<Song> songList4;
    List<Song> songList5;
    List<Song> songListBLANK;
    //This method will be executed before all the other methods.
    @Before
    public void before() {
        String path = "res/"; //<- Assign the path of the .csv files to this variable. Do not include the file name,
// it will be added below.
        songList1 = SongsReader.readFile(path + "classichits.csv");
        songList2 = SongsReader.readFile(path + "classichits2.csv");
        songList3 = SongsReader.readFile(path + "classichits3.csv");
        songList4 = SongsReader.readFile(path + "classichits4.csv");
        songList5 = SongsReader.readFile(path + "classichits5.csv");
        songListBLANK = SongsReader.readFile(path + "classichitsBLANK.csv");
    }
    @Test
    public void problem1() {
        assertEquals(3083,
                SongsStats.problem1_countArtists(songList1.stream()));
        assertEquals(44, SongsStats.problem1_countArtists(songList2.stream()));
        assertEquals(32, SongsStats.problem1_countArtists(songList3.stream()));
        assertEquals(0,
                SongsStats.problem1_countArtists(songListBLANK.stream()));
    }
    @Test
    public void problem2() {
        assertEquals("Be Near Me, When Smokey Sings",
                SongsStats.problem2_getTracksByArtist(songList1.stream(), "ABC"));
        assertEquals("Amazing, Angel, Crazy, Cryin’, Don't Get Mad,Get Even, Dream On, Home Tonight, I Don’t Want To Miss A Thing, Janie’s Got A Gun, Lightning Strikes, Livin’ On The Edge, Love In An Elevator, Luv Lies, Milk Cow Blues, She's On Fire, The Reason A Dog, Train Kept a Rollin', Walk This Way, What It Takes, Write Me a Letter",
        SongsStats.problem2_getTracksByArtist(songList1.stream(), "Aerosmith"));
        assertEquals("21st Century Schizoid Man - Including Mirrors, Epitaph - Including March for No Reason and Tomorrow and Tomorrow, The Court Of The Crimson King - Including The Return of the Fire Witch and The Dance of the Puppets, The Devils Triangle, The Night Watch",
        SongsStats.problem2_getTracksByArtist(songList3.stream(), "King Crimson"));
        assertEquals("21st Century Schizoid Man - Including Mirrors, Epitaph - Including March for No Reason and Tomorrow and Tomorrow, Indiscipline, Red, The Court Of The Crimson King - Including The Return of the Fire Witch and The Dance of the Puppets, The Devils Triangle, The Night Watch",
        SongsStats.problem2_getTracksByArtist(songList1.stream(), "King Crimson"));
        assertEquals("",
                SongsStats.problem2_getTracksByArtist(songList1.stream(), "Emily Navarro"));
        assertEquals("",
                SongsStats.problem2_getTracksByArtist(songListBLANK.stream(), "ABC"));
    }
    @Test
    public void problem3() {
        Optional<Song> result =
                SongsStats.problem3_getFastestSong(songList1.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            Song fastest = result.get();
            assertEquals("I’ll Be There For You/You’re All I Need To Get",
                    fastest.getTrack());
        }
        result = SongsStats.problem3_getSlowestSong(songList1.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            String slowest = result.get().getTrack();
            assertTrue(slowest.equals("Hello,Dolly!") || slowest.equals("Loop De Loop"));
        }
        result = SongsStats.problem3_getFastestSong(songList2.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            Song fastest = result.get();
            assertEquals("Balada o Pisonji I Zugi-live", fastest.getTrack());
        }
        result = SongsStats.problem3_getSlowestSong(songList2.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            Song slowest = result.get();
            assertEquals("A Szerelemről", slowest.getTrack());
        }
        result = SongsStats.problem3_getFastestSong(songList3.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            Song fastest = result.get();
            assertEquals("Police Truck", fastest.getTrack());
        }
        result = SongsStats.problem3_getSlowestSong(songList3.stream());
        assertTrue(result.isPresent());
        if (result.isPresent()) {
            Song slowest = result.get();
            assertEquals("A Long December", slowest.getTrack());
        }
        result = SongsStats.problem3_getFastestSong(songListBLANK.stream());
        assertFalse(result.isPresent());
        result = SongsStats.problem3_getSlowestSong(songListBLANK.stream());
        assertFalse(result.isPresent());
    }
    @Test
    public void problem4() {
        List<Key> result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(1969), Year.of(1969)); // [E]
        assertEquals(1, result.size());
        assertTrue(result.contains(Key.E));
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(1977), Year.of(1977)); // [CSHARP_DFLAT, A]
        assertEquals(2, result.size());
        assertTrue(result.contains(Key.CSHARP_DFLAT) &&
                result.contains(Key.A));
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(1990), Year.of(1999)); // [A, G, C, D]
        assertEquals(4, result.size());
        assertTrue(result.contains(Key.A) && result.contains(Key.G) &&
                result.contains(Key.C) && result.contains(Key.D));
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(2000), Year.of(2024)); // [A]
        assertEquals(1, result.size());
        assertTrue(result.contains(Key.A));
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(1900), Year.of(2030)); // [A]
        assertEquals(1, result.size());
        assertTrue(result.contains(Key.A));
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songList3.stream(),
                        Year.of(2024), Year.of(2030)); // []
        assertTrue(result.isEmpty());
        result =
                SongsStats.problem4_getMostPopularKeyInYearRange(songListBLANK.stream(),
                        Year.of(1900), Year.of(2030)); // []
        assertTrue(result.isEmpty());
    }
    @Test
    public void problem5() {
        Map<String, Long> expected = new TreeMap<>();
        assertEquals(expected,
                SongsStats.problem5_countSongsByGenre(songListBLANK.stream())); // empty map
        expected.put("Alt. Rock", 780L);
        expected.put("Blues", 683L);
        expected.put("Country", 833L);
        expected.put("Disco", 652L);
        expected.put("EDM", 700L);
        expected.put("Folk", 575L);
        expected.put("Funk", 388L);
        expected.put("Gospel", 311L);
        expected.put("Jazz", 778L);
        expected.put("Metal", 922L);
        expected.put("Pop", 3669L);
        expected.put("Punk", 754L);
        expected.put("R&B", 822L);
        expected.put("Rap", 718L);
        expected.put("Reggae", 439L);
        expected.put("Rock", 799L);
        expected.put("SKA", 381L);
        expected.put("Today", 620L);
        expected.put("World", 326L);
        assertEquals(expected,
                SongsStats.problem5_countSongsByGenre(songList1.stream()));
        expected.clear();
        expected.put("Today", 69L);
        expected.put("World", 165L);
        assertEquals(expected,
                SongsStats.problem5_countSongsByGenre(songList2.stream()));
        expected.clear();
        expected.put("Alt. Rock", 244L);
        assertEquals(expected,
                SongsStats.problem5_countSongsByGenre(songList3.stream()));
        expected.clear();
        expected.put("Country",3L);
        expected.put("Funk", 2L);
        expected.put("Gospel", 311L);
        expected.put("Jazz", 1L);
        expected.put("Metal", 1L);
        expected.put("Pop", 10L);
        expected.put("Reggae", 22L);
        expected.put("World", 76L);
        assertEquals(expected,
                SongsStats.problem5_countSongsByGenre(songList4.stream()));
    }
    @Test
    public void problem6() {
        assertEquals(1379,
                SongsStats.problem6_countDuplicateSongs(songList1.stream()));
        assertEquals(0,
                SongsStats.problem6_countDuplicateSongs(songList2.stream()));
        assertEquals(1,
                SongsStats.problem6_countDuplicateSongs(songList3.stream()));
        assertEquals(5,
                SongsStats.problem6_countDuplicateSongs(songList4.stream()));
        assertEquals(0,
                SongsStats.problem6_countDuplicateSongs(songListBLANK.stream()));
    }
    @Test
    public void problem7() {
        assertEquals("Green Day",
                SongsStats.problem7_getMostPopularArtist(songList3.stream()));
        String artist =
                SongsStats.problem7_getMostPopularArtist(songList5.stream());
        assertTrue(artist.equals("Blur") || artist.equals("CAKE"));
        assertEquals("",
                SongsStats.problem7_getMostPopularArtist(songListBLANK.stream()));
    }
    @Test
    public void problem8() {
        assertEquals(0.25800532786885244,
                SongsStats.problem8_getAverageDifferenceBetweenEnergyAndDanceability(songList3.stream()), EPSILON);
        assertEquals(0.06529415492957746,
                SongsStats.problem8_getAverageDifferenceBetweenEnergyAndDanceability(songList4.stream()), EPSILON);
        assertEquals(0.1200340425531915,
                SongsStats.problem8_getAverageDifferenceBetweenEnergyAndDanceability(songList5.stream()), EPSILON);
        assertEquals(0,
                SongsStats.problem8_getAverageDifferenceBetweenEnergyAndDanceability(songListBLANK.
                        stream()), EPSILON);
    }
    @Test
    public void problem9() {
        assertEquals("Because the Night - Live Unplugged",
                SongsStats.problem9_getFirstTrackContainingString(songList5.stream(),
                        "the").getTrack());
        assertEquals("Candy Everybody Wants",
                SongsStats.problem9_getFirstTrackContainingString(songList5.stream(),
                        "and").getTrack());
        assertNull(SongsStats.problem9_getFirstTrackContainingString(songList5.stream(),
                "love"));
        assertEquals("(AT Your Best) You Are Love",
                SongsStats.problem9_getFirstTrackContainingString(songList1.stream(),
                        "love").getTrack());
        assertNull(SongsStats.problem9_getFirstTrackContainingString(songList1.stream(),
                "Robert Navarro"));
        assertNull(SongsStats.problem9_getFirstTrackContainingString(songListBLANK.stream()
                , "love"));
    }
    @Test
    public void problem10() {
        List<String> result =
                SongsStats.problem10_getGenres(songList1.stream());
        assertEquals(19, result.size());
        assertEquals("Alt. Rock", result.get(0));
        assertEquals("Blues", result.get(1));
        assertEquals("Country", result.get(2));
        assertEquals("Disco", result.get(3));
        assertEquals("EDM", result.get(4));
        assertEquals("Folk", result.get(5));
        assertEquals("Funk", result.get(6));
        assertEquals("Gospel", result.get(7));
        assertEquals("Jazz", result.get(8));
        assertEquals("Metal", result.get(9));
        assertEquals("Pop", result.get(10));
        assertEquals("Punk", result.get(11));
        assertEquals("R&B", result.get(12));
        assertEquals("Rap", result.get(13));
        assertEquals("Reggae", result.get(14));
        assertEquals("Rock", result.get(15));
        assertEquals("SKA", result.get(16));
        assertEquals("Today", result.get(17));
        assertEquals("World", result.get(18));
        result = SongsStats.problem10_getGenres(songList2.stream());
        assertEquals(2, result.size());
        assertEquals("Today", result.get(0));
        assertEquals("World", result.get(1));
        result = SongsStats.problem10_getGenres(songList3.stream());
        assertEquals(1, result.size());
        assertEquals("Alt. Rock", result.get(0));
        result = SongsStats.problem10_getGenres(songList4.stream());
        assertEquals(8, result.size());
        assertEquals("Country", result.get(0));
        assertEquals("Funk", result.get(1));
        assertEquals("Gospel", result.get(2));
        assertEquals("Jazz", result.get(3));
        assertEquals("Metal", result.get(4));
        assertEquals("Pop", result.get(5));
        assertEquals("Reggae", result.get(6));
        assertEquals("World", result.get(7));
        result = SongsStats.problem10_getGenres(songList5.stream());
        assertEquals(1, result.size());
        assertEquals("Alt. Rock", result.get(0));
        result = SongsStats.problem10_getGenres(songListBLANK.stream());
        assertTrue(result.isEmpty());
    }
}
