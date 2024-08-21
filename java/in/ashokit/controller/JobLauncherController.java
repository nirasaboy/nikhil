package in.ashokit.controller;

	
		import org.springframework.batch.core.Job;
	import org.springframework.batch.core.JobParametersBuilder;
	import org.springframework.batch.core.launch.JobLauncher;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class JobLauncherController {

	    @Autowired
	    private JobLauncher jobLauncher;

	    @Autowired
	    private Job job;

	    @GetMapping("/launch-job")
	    public String handle() throws Exception {
	        jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
	        return "Job launched!";
	    }
	}



