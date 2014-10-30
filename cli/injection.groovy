import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource

interface Animal{String name}
@Service
class Dog implements Animal{ void bark(){println "bark"}}
@Service
class Cat implements Animal{void meow(){println "meow"}}

@RestController
class Main{
	@Resource
	@Qualifier("dog")
	Animal animal

	@RequestMapping("/")
	public String hello(){
		return "hello world"
	}
}
