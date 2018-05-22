import org.hersels.common.security.TestValidationListenerScanner;
import org.hersels.common.security.TestValidationManager;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestValidationListenerScanner.class, TestValidationManager.class})
public class AllCommonTests {

}
