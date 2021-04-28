package cat.itb.project.Services;

import cat.itb.project.model.Videogames;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class VideogameServices {
    private List<Videogames> repositori=new ArrayList<>();

    public void add(Videogames v){repositori.add(v);}

    public List<Videogames>listAll(){return repositori;}

    public List<Videogames>orderByName(){
        Collections.sort(repositori, new Comparator<Videogames>() {
            @Override
            public int compare(Videogames o1, Videogames o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return repositori;
    }

    public void eliminarPerId(int id){
        repositori.removeIf(e -> e.getId() == id);
    }

    public Videogames consultaPerId(int id){
        Videogames gameId=null;
        for(Videogames v:repositori){
            if(v.getId()==id){
                gameId=v;
            }
        }
        return gameId;
    }

    public void substituir(Videogames game){
        for(Videogames v:repositori){
            if(v.getId()==game.getId()){
                v.setTitle(game.getTitle());
                v.setPlatform(game.getTitle());
                v.setLaunchDate(game.getLaunchDate());
            }
        }
    }


    @PostConstruct
    public void init() {
        repositori.addAll(
                Arrays.asList(
                        new Videogames(1,"Persona 3 FES","PS2","02-03-2002"),
                        new Videogames(2,"Persona 5","PS4","04-10-2015")
                )
        );
    }

}
