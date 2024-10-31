package theater.project.MovieTheater.DataPersistent.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_description")
    private String description;


    @Lob
    @Column(name = "cover_image")
    private byte[] coverImage;

    @Transient
    private String coverImageBase64;
}
