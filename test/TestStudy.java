import me.wener.practices.web.common.entity.Sex;
import org.junit.Test;

interface A
{
}

interface B
{
}

public class TestStudy
{
    @Test
    public void testNestTypeParameter()
    {

    }

    @Test
    public void testEnumConvert()
    {
        System.out.println(Sex.Female);
        System.out.println(Sex.Male);
        System.out.println(String.valueOf(Sex.Female));
        System.out.println(Sex.valueOf("Male"));
        System.out.println();
    }

    @Test
    public void testStringConvert()
    {
        System.out.println(Long.parseLong(null));
        System.out.println(Long.parseLong(""));
    }
}

class C<TA, TB>
{
}

class CAB extends C<A, B>
{
}

class D<TX extends C<TA, TB>, TA, TB>
{
}

// TODO 可能不写 A,B 参数么? 因为 CAB 里可以推出 A,B 参数
class DCA extends D<CAB, A, B>
{
}
//class DCA extends D<CAB,?,?>{}


abstract class P<TA, TB>
{
    public abstract <T extends C<TA, TB>> T t();
}

class PAB extends P<A, B>
{

    // TODO 有办法避免这个 uncheck 么
    @Override
    public CAB t()
    {
        return null;
    }
}