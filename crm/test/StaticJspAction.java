import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.ServletOutputStream;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
public class StaticJspAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
        System.out.println("Just running.");
        ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
        out.print("DONE");
        return NONE;
    }
}
