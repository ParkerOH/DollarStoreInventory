package assign6;

import java.util.Calendar;

public class Student extends Member {

	public Student(int memberID) {
		super(memberID);
	}

	@Override
	public Calendar calculateNewBookDueDate(Calendar startDate) {
        Calendar newDate = (Calendar)startDate.clone();
        newDate.add(Calendar.DATE, 28);  //Books are checked out for 4 weeks
        return newDate;
	}

}
