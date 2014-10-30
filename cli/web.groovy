@Controller
class Example {
	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		"Hello Spring boot audience!!!"
	}
}
