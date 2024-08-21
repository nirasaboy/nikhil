package in.ashokit.config;


	
	import org.springframework.batch.core.JobExecution;
	import org.springframework.batch.core.JobExecutionListener;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Component;

	import javax.sql.DataSource;

	@Component
	public class JobCompletionNotificationListener implements JobExecutionListener {

	    private final JdbcTemplate jdbcTemplate;

	    public JobCompletionNotificationListener(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    @Override
	    public void beforeJob(JobExecution jobExecution) {
	        // No-op
	    }

	    @Override
	    public void afterJob(JobExecution jobExecution) {
	        if (jobExecution.getStatus() == org.springframework.batch.core.BatchStatus.COMPLETED) {
	            System.out.println("Job finished. Checking results:");

	            jdbcTemplate.query("SELECT id, name FROM person",
	                    (rs, row) -> {
	                        System.out.println("Found <" + rs.getInt(1) + ", " + rs.getString(2) + "> in the database.");
	                        return null;
	                    });
	        }
	    }
	}



