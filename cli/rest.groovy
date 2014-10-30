@RestController
class Example {
	@RequestMapping("/")
	@ResponseBody
	public Person get() {
		Person person=new Person(id:10, name:"Bhagwat")
		return person
	}

	@RequestMapping("/list")
	@ResponseBody
	public Map list() {
		[persons: [new Person(id:10, name:"Bhagwat"), new Person(id:20, name:'Kumar')]]
	}

	@RequestMapping("/save")
	@ResponseBody
	public Person save(Person person) {
		println person.dump()
		return person
	}
}
class Person{Long id; String name}
