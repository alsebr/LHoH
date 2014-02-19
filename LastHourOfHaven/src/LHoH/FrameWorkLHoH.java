package LHoH;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameWorkLHoH {
	static String ttlToTime(double ttl){
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		String result = sdf.format(new Date((int)ttl*1000));
		return result;
	}
}
