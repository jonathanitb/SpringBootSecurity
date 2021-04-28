package cat.itb.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videogames {
    private int id;
    private String Title;
    private String platform;
    private String launchDate;
}
