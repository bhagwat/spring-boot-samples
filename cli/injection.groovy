import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource

interface Animal{public void saySomething()}

@Service
class Dog implements Animal{ void saySomething(){println "bark"}}

@Service
class Cat implements Animal{void saySomething(){println "meow"}}

@RestController
class Main{

  @Resource
  @Qualifier("dog")
  Animal animal

  @RequestMapping("/")
  public String hello(){
	animal.saySomething()

	return "hello world"
  }
}
