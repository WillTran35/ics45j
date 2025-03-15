package labs.lab10;
import java.time.Year;
public class Song {
    private String track; // title of the song
    private String artist; // name of the performing artist/band
    private Year year; // year the track was released
    private int duration; // length of the track in milliseconds
    private int timeSignature; // the musical time signature of the track
    private double danceability; // A measure of how suitable the track is for dancing,
    // ranging from 0.0 to 1.0
    private double energy; // A measure of the intensity and activity of the track,
    // ranging from 0.0 to 1.0
    private Key key; // The key of the track
    private double loudness; // The overall loudness of the track in decibels(dB)
    private Mode mode; // The mode of the track (major or minor)
    private double speechiness; // A measure indicating the presence of spoke words in
    // the track, ranging from 0.0 to 1.0
    private double acousticness; // A measure of how acoustic the track is,ranging
    // from 0.0 to 1.0
    private double instrumentalness; // A measure of the likelihood that thetrack is
// instrumental, ranging from 0.0 to 1.0
    private double liveness; // A measure of the presence of a live audience inthe
    // track, ranging from 0.0 to 1.0
    private double valence; // A measure of the musical positiveness of the track,
    // ranging from 0.0 to 1.0
    private double tempo; // The speed of the track in beats per minute (BPM)
    private int popularity; // A measure of the track's popularity, ranging from 0 to
    // 100
    private String genre; // genre of the song
    public Song(String track, String artist, Year year, int duration, int
                        timeSignature,
                double danceability, double energy, Key key, double loudness,
                Mode mode,
                double speechiness, double acousticness, double instrumentalness,
                double liveness, double valence, double tempo, int popularity,
                String genre) {
        this.track = track;
        this.artist = artist;
        this.year = year;
        this.duration = duration;
        this.timeSignature = timeSignature;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.popularity = popularity;
        this.genre = genre;
    }
    public String getTrack() {
        return track;
    }
    public String getArtist() {
        return artist;
    }
    public Year getYear() {
        return year;
    }
    public int getDuration() {
        return duration;
    }
    public int getTimeSignature() {
        return timeSignature;
    }
    public double getDanceability() {
        return danceability;
    }
    public double getEnergy() {
        return energy;
    }
    public Key getKey() {
        return key;
    }
    public double getLoudness() {
        return loudness;
    }
    public Mode getMode() {
        return mode;
    }
    public double getSpeechiness() {
        return speechiness;
    }
    public double getAcousticness() {
        return acousticness;
    }
    public double getInstrumentalness() {
        return instrumentalness;
    }
    public double getLiveness() {
        return liveness;
    }
    public double getValence() {
        return valence;
    }
    public double getTempo() {
        return tempo;
    }
    public int getPopularity() {
        return popularity;
    }
    public String getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        return "Track: " + track + ", Artist: " + artist + ", Year: " + year
                + ", Duration: " + duration +
                ", Time Signature: " + timeSignature + ", Danceability: " +
                danceability + ", Energy: " +
                energy + ", Key: " + key + ", Loudness: " + loudness + ", Mode: " + mode + ", Speechiness: " + speechiness + ", Acousticness: " +
                acousticness +
                ", Instrumentalness: " + instrumentalness + ", Liveness: "
                + liveness + ", Valence: " +
                valence + ", Tempo: " + tempo + ", Popularity: " +
                popularity + ", Genre: " + genre;
    }
    @Override
    public int hashCode() {
        return track.hashCode() * artist.hashCode() * year.hashCode() *
                duration * timeSignature *
                (int) danceability * (int) energy * key.hashCode() * (int)
                loudness * mode.hashCode() *
                (int) speechiness * (int) acousticness * (int)
                instrumentalness * (int) liveness *
                (int) valence * (int) tempo * popularity *
                genre.hashCode();
    }
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Song) {
            Song other = (Song)otherObject;
            return this.track.equals(other.track)
                    && this.artist.equals(other.artist)
                    && this.year.equals(other.year)
                    && this.duration == other.duration
                    && this.timeSignature == other.timeSignature
                    && this.danceability == other.danceability
                    && this.energy == other.energy
                    && this.key == other.key
                    && this.loudness == other.loudness
                    && this.mode == other.mode
                    && this.speechiness == other.speechiness
                    && this.acousticness == other.acousticness
                    && this.instrumentalness == other.instrumentalness
                    && this.liveness == other.liveness
                    && this.valence == other.valence
                    && this.tempo == other.tempo
                    && this.popularity == other.popularity
                    && this.genre.equals(other.genre);
        }
        return false;
    }
}
