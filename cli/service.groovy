@Controller
class Example {
 @Autowired ServiceExample serviceExample
 @Autowired ComponentExample componentExample
 @Autowired RepositoryExample repositoryExample
 @Autowired String appName
 @Autowired String appVersion

 @RequestMapping("/")
 public String serve(){
	println serviceExample.sayHello()
	println componentExample.sayHello()
	println repositoryExample.sayHello()
	println appName
	println appVersion
	return "Request served. Check log...."
 }
}

@Service
class ServiceExample {
 public String sayHello(){"Hello from Service Example"}
}

@Component
class ComponentExample{
 public String sayHello(){"Hello from Component Example"}
}

@Repository
class RepositoryExample{
 public String sayHello(){"Hello from Repository example"}
}

@Configuration
class BeanDefination{
  @Bean
  String appName(){return "Test app"}

  @Bean(name = "appVersion")
  String getVersion(){return "1.0.0"}
}
