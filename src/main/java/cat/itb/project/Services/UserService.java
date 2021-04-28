package cat.itb.project.Services;



import cat.itb.project.model.UserModel;
import cat.itb.project.repositori.userRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
@Service
public class UserService {
    @Autowired
 private userRepositori repositori;
    public void addUser(UserModel u){
     u.setId((int) (repositori.count()+1));
     u.setPassword(passwordEncoder(u.getPassword()));
     repositori.save(u);
 }
 @PostConstruct
 public void init(){
        if (!repositori.existsById(1)){
            UserModel user1=new UserModel(1,"user1",passwordEncoder("pass1"),"user");
            repositori.save(user1);
        }
     if (!repositori.existsById(2)){
         UserModel admin=new UserModel(2,"admin",passwordEncoder("admin1"),"admin");
         repositori.save(admin);
     }
 }
    public UserModel searchUsername(String username){
        UserModel user=null;
        for(UserModel u:repositori.findAll()){
            if(username.equals(u.getUsername())){
                user=u;
                System.out.println(user);
            }
        }
        return user;
    }
    public String passwordEncoder(String password){
     return new BCryptPasswordEncoder().encode(password);
 }
}
