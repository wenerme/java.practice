import me.wener.practices.crm.sys.department.entity.DepartmentEntity_;
import me.wener.practices.crm.sys.employee.entity.UserEntity_;
import org.junit.Test;

public class MetaModelTest
{
    @Test
    public void testA()
    {
        System.out.println(UserEntity_.account.getName());
        System.out.println(DepartmentEntity_.description.getName());
    }
}
