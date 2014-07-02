package spring;

import com.google.common.base.Charsets;
import java.util.Date;
import java.util.GregorianCalendar;
import lombok.Data;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class PlayEL
{
    @Test
    public void test()
    {
        ExpressionParser parser = new SpelExpressionParser();
        // invokes getBytes()
        Expression exp = parser.parseExpression("'Hello World'.concat('!').bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(new String(bytes, Charsets.UTF_8));

        exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
    }

    @Test
    public void withContext()
    {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        System.out.println("Name is "+name);

        exp = parser.parseExpression("name = 'wener'");
        name = exp.getValue(context, String.class);
        assert name.equals("wener");
        System.out.println("New Name is "+name);

    }
    @Data
    public class Inventor
    {

        private String country;
        private Date birth;
        private String name;

        public Inventor(String name, Date birth, String country)
        {
            this.name = name;
            this.birth = birth;
            this.country = country;
        }
    }
}
