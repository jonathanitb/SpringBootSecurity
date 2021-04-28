package cat.itb.project.repositori;

import cat.itb.project.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface userRepositori extends CrudRepository<UserModel,Integer> {
}
