package handler;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class HolidayRejectionHandler implements JavaDelegate {
	 @Override
	    public void execute(DelegateExecution execution) {

	        log.info("Holiday has been rejected, sending an email ");

	    }
}
