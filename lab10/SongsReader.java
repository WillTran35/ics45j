package labs.lab10;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * Utility class for reading in a file of Song data
 */
public class SongsReader {
    /**
     * Reads in a file of Song data and returns a list of Song objects
     *
     * @param filename name of file containing Song data
     *
     * @return list of Song objects from the file
     */
    public static List<Song> readFile(String filename) {
        List<Song> songs = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            if (in.hasNextLine()) {
                in.nextLine(); // consume column heading line
            }
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.length() > 0) {
                    List<String> fields = getFields(line);
/*
* The format of each line is:
*
Track,Artist,Year,Duration,Time_Signature,Danceability,Energy,Key,Loudness,Mode,Spe
echiness,Acousticness,Instrumentalness,Liveness,Valence,Tempo,Popularity,Genre
*/
                    String track = fields.get(0).replaceAll("\"", "");
// System.out.println("track: " + track);
                    String artist = fields.get(1);
// System.out.println("artist: " + artist);
                    Year year = Year.parse(fields.get(2));
// System.out.println("year: " + year);
                    int duration = Integer.parseInt(fields.get(3));
// System.out.println("duration: " + duration);
                    int timeSignature = Integer.parseInt(fields.get(4));
// System.out.println("time signature: " timeSignature);
                    double danceability =
                            Double.parseDouble(fields.get(5));
// System.out.println("danceability: " + danceability);
                    double energy = Double.parseDouble(fields.get(6));
// System.out.println("energy: " + energy);
                    Key key =
                            Key.getValue(Integer.parseInt(fields.get(7)));
// System.out.println("key: " + key);
                    double loudness = Double.parseDouble(fields.get(8));
// System.out.println("loudness: " + loudness);
                    Mode mode =
                            Mode.getValue(Integer.parseInt(fields.get(9)));
// System.out.println("mode: " + mode);
                    double speechiness =
                            Double.parseDouble(fields.get(10));
// System.out.println("speechiness: " + speechiness);
                    double acousticness =
                            Double.parseDouble(fields.get(11));
// System.out.println("acousticness: " + acousticness);
                    double instrumentalness =
                            Double.parseDouble(fields.get(12));
// System.out.println("instrumentalness: " +instrumentalness);
                    double liveness = Double.parseDouble(fields.get(13));
// System.out.println("liveness: " + liveness);
                    double valence = Double.parseDouble(fields.get(14));
// System.out.println("valence: " + valence);
                    double tempo = Double.parseDouble(fields.get(15));
// System.out.println("tempo: " + tempo);
                    int popularity = Integer.parseInt(fields.get(16));
// System.out.println("popularity: " + popularity);
                    String genre = fields.get(17);
// System.out.println("genre: " + genre);
                    songs.add(new Song(track, artist, year, duration,
                            timeSignature, danceability,
                            energy, key, loudness, mode, speechiness,
                            acousticness,
                            instrumentalness, liveness, valence,
                            tempo, popularity, genre));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File: " + filename + " not found");
        }
        return songs;
    }
    /**
     * Extract fields from a String corresponding to a row in the CSV file.
     * Handles fields surrounded by quotes.
     *
     * @param row the text of the row
     * @return a list of fields in the given row
     */
    private static List<String> getFields(String row) {
        String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        return Arrays.asList(tokens);
    }
}
