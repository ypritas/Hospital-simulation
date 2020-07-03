import com.sun.tools.javac.Main;
import org.junit.Test;

public class MainTest {

    @Test
    public void testHospital() {
         Hospital.main(new String[] {"D,F,F", "As,I"});
    }
}
