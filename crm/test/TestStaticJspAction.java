import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class TestStaticJspAction extends StrutsJUnit4TestCase<StaticJspAction>
{

    @Override
    protected String getConfigPath() {
        return "struts-static-jsp.xml";
    }

    @Test
    public void testUserNameErrorMessage() throws Exception {

        request.setParameter("accountBean.userName", "Bruc");
        request.setParameter("accountBean.password", "test");

        ActionProxy proxy = getActionProxy("/abc.jsp");

        StaticJspAction accountAction = (StaticJspAction) proxy.getAction();

        proxy.execute();

//        assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", accountAction.getFieldErrors().size() == 1);
//        assertTrue("Problem field account.userName not present in fieldErrors but it should have been",
//                accountAction.getFieldErrors().containsKey("accountBean.userName") );

    }

    public void testUserNameCorrect() throws Exception {

        request.setParameter("accountBean.userName", "Bruce");
        request.setParameter("accountBean.password", "test");

        ActionProxy proxy = getActionProxy("/createaccount");

        StaticJspAction accountAction = (StaticJspAction) proxy.getAction();

        String result = proxy.execute();


    }

}
