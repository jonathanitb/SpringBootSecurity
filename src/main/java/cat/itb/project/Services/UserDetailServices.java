package cat.itb.project.Services;

import cat.itb.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServices implements UserDetailsService {
    @Autowired
    private UserService userServ;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user=userServ.searchUsername(s);
        User.UserBuilder bulder=null;
        if(user!=null){
            bulder=User.withUsername(user.getUsername());
            bulder.disabled(false);
            bulder.password(user.getPassword());
            bulder.roles(user.getRole());
        }else throw new UsernameNotFoundException("User doesn't exist");
        return bulder.build();
    }
}
